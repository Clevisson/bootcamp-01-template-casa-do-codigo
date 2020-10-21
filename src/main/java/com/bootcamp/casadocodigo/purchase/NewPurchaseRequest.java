package com.bootcamp.casadocodigo.purchase;

import com.bootcamp.casadocodigo.command.Command;
import com.bootcamp.casadocodigo.command.NewCommandRequest;
import com.bootcamp.casadocodigo.coupon.Coupon;
import com.bootcamp.casadocodigo.coupon.CouponRepository;
import com.bootcamp.casadocodigo.validations.UniqueId;
import com.bootcamp.casadocodigo.country.Country;
import com.bootcamp.casadocodigo.state.State;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;

public class NewPurchaseRequest {
    @Email
    @NotBlank
    private final String email;
    @NotBlank
    private final String name;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String document;
    @NotBlank
    private final String address;
    @NotBlank
    private final String complement;
    @NotBlank
    private final String city;
    @NotBlank
    @UniqueId(domainClass = Country.class, fieldName = "id")
    private final Long idCountry;
    @UniqueId(domainClass = State.class, fieldName = "id")
    private final Long idState;
    @NotBlank
    private final String telephone;
    @NotBlank
    private final String cep;

    private final NewCommandRequest order;
    @UniqueId(domainClass = Coupon.class, fieldName = "code")

    private String couponCode;

    public NewPurchaseRequest(@Email @NotBlank String email,
                              @NotBlank String name,
                              @NotBlank String lastName,
                              @NotBlank String document,
                              @NotBlank String address,
                              @NotBlank String complement,
                              @NotBlank String city,
                              @NotBlank Long idCountry,
                              Long idEstado,
                              @NotBlank String telephone,
                              @NotBlank String cep,
                              @Valid @NotNull NewCommandRequest order) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.idCountry = idCountry;
        this.idState = idEstado;
        this.telephone = telephone;
        this.cep = cep;
        this.order = order;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public Purchase toModel(EntityManager manager, CouponRepository couponRepository) {
        @NotNull
        Country country = manager.find(Country.class, idCountry);
        Function<Purchase, Command> funCreateOrder = order.toModel(manager);

        Purchase purchase = new Purchase(email, name, lastName, document, address, complement, city, country, telephone, cep, funCreateOrder);

        if (idState != null) {
            purchase.setState(manager.find(State.class, idState));
        }
        if (StringUtils.hasText(couponCode)) {
            Coupon coupon = couponRepository.getByCode(couponCode);
            purchase.appyCoupon(coupon);
        }
        return purchase;

    }

    public boolean validDocument() {
        Assert.hasLength(document,
                "você não deveria validar o documento se ele não tiver sido preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(document, null)
                || cnpjValidator.isValid(document, null);
    }

    public boolean hasState() {
        return idState != null;
    }

    public Optional<String> getCouponCode() {
        return Optional.ofNullable(couponCode);
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public NewCommandRequest getOrder() {
        return order;
    }

    public String getDocument() {
        return document;
    }
}
