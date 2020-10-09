package com.clevisson.casadocodigo.genericvalidation;

import org.springframework.validation.annotation.Validated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {UniqueIdValidator.class})
public @interface UniqueId {
    String message() default "Descreva a mensagem aqui!";
            Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
