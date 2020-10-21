package com.bootcamp.casadocodigo.command;

import com.bootcamp.casadocodigo.purchase.Purchase;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private @NotNull @Valid Purchase purchase;

    @ElementCollection
    @Size(min = 1)
    private Set<CommandItem> items = new HashSet<>();

    public Command(Purchase purchase, @Size(min = 1) Set<CommandItem> items) {
        Assert.isTrue(!items.isEmpty(), "O pedido deve conter ao menos um item");
        this.purchase = purchase;
        this.items.addAll(items);
    }

    public boolean EqualTotal(@Positive @NotNull BigDecimal amount) {
        BigDecimal OrderTotal = items.stream().map(CommandItem::total).reduce(BigDecimal.ZERO,
                (atual, proximo) -> atual.add(proximo));
        return OrderTotal.doubleValue() == amount.doubleValue();
    }
}
