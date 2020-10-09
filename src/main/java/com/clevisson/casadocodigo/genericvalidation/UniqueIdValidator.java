package com.clevisson.casadocodigo.genericvalidation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.awt.*;
import java.util.List;

public class UniqueIdValidator implements ConstraintValidator<UniqueId, Object> {
    private String domainAttibute;
    private Class<?> kclass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueId params) {
        domainAttibute = params.fieldName();
        kclass = params.domainClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //Query query = entityManager.createQuery("select 1 from " + kclass.getName() + "where" + domainAttibute + "=:value");
        Query query = entityManager.createQuery("select 1 from "+kclass.getName()+" where "+domainAttibute+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <= 1, "Foi encontrado mais de um " + kclass + " com o atributo " + domainAttibute + " com valor  = " + value);
        return !list.isEmpty();
    }
}
