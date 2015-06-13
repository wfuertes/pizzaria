package com.matera.pizzaria.service;

import com.matera.pizzaria.model.Pizza;
import com.matera.pizzaria.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author wbatista
 */
@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(final PizzaRepository pizzaRepository) {

        this.pizzaRepository = pizzaRepository;
    }

    public String addNewPizza(Pizza pizza) {

        pizzaRepository.save(pizza);
        return "Pizza adicionada com sucesso!";
    }
}
