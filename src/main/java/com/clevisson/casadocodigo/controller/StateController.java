package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.model.State;
import com.clevisson.casadocodigo.request.newStateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/state")
public class StateController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public String createEstate(@RequestBody @Valid newStateRequest request) {
        State state = request.toModel(manager);
        manager.persist(state);
        return "Salvei no banco";
    }
}
