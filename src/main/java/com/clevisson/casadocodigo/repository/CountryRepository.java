package com.clevisson.casadocodigo.repository;

import com.clevisson.casadocodigo.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
