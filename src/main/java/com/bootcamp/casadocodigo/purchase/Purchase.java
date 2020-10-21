package com.bootcamp.casadocodigo.purchase;

import com.bootcamp.casadocodigo.command.Command;
import com.bootcamp.casadocodigo.country.Country;
import com.bootcamp.casadocodigo.coupon.Coupon;
import com.bootcamp.casadocodigo.coupon.CouponApplied;
import com.bootcamp.casadocodigo.state.State;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @ManyToOne
    @NotNull
    private Country country;
    @ManyToOne
    private State state;
    @NotBlank
    private String telephone;
    @NotBlank
    private String cep;

    @OneToOne(mappedBy = "purchase", cascade = CascadeType.PERSIST)
    private Command command;

    @Embedded
    private CouponApplied couponApplied;

    @Deprecated
    public Purchase() {
    }

    public Purchase(@Email @NotBlank String email, @NotBlank String name,
                    @NotBlank String lastName, @NotBlank String document,
                    @NotBlank String address, @NotBlank String complement,
                    @NotBlank String city, @NotNull Country country,
                    @NotBlank String telephone, @NotBlank String cep,
                    Function<Purchase, Command> funCreateOrder) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.telephone = telephone;
        this.cep = cep;
        this.command = funCreateOrder.apply(this);
    }

    public void setState(@NotNull @Valid State state) {
        Assert.notNull(country, "Erro ao associar estado, pois pais é nulo");
        Assert.isTrue(state.belongsCountry(country), "Este estado não contém um país associado a uma compra");
        this.state = state;
    }

    public void appyCoupon(Coupon coupon) {
        Assert.isTrue(coupon.valid(), "Cupom aplicado não é mais válido");
        Assert.isNull(couponApplied, "Cumpom não pode ser trocado");
        this.couponApplied = new CouponApplied(coupon);
    }
}
