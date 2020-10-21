package com.bootcamp.casadocodigo.command;

import com.bootcamp.casadocodigo.purchase.Purchase;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewCommandRequest {
    @Positive
    @NotNull
    private final BigDecimal amount;
    @Size(min = 1)
    @Valid
    private List<NewItemCommandRequest> items = new ArrayList<>();

    public NewCommandRequest(@Positive @NotNull BigDecimal amount,
                             @Size(min = 1) @Valid List<NewItemCommandRequest> items) {
        this.amount = amount;
        this.items = items;
    }

    public List<NewItemCommandRequest> getItems() {
        return items;
    }

    public Function<Purchase, Command> toModel(EntityManager manager) {

        Set<CommandItem> calculatedItems = items.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());

        return (compra) -> {
            Command command = new Command(compra, calculatedItems);
            Assert.isTrue(command.EqualTotal(amount), "O total está divergente do total real");
            return command;
        };

    }
}
