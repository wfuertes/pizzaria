package com.matera.pizzaria.service;

import com.matera.pizzaria.dao.PizzaDAO;
import com.matera.pizzaria.model.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author wbatista
 */
@Service
public class PizzaService {

    private final PizzaDAO pizzariaDAO;

    @Autowired
    public PizzaService(final PizzaDAO pizzariaDAO) {

        this.pizzariaDAO = pizzariaDAO;
    }

    public String addNewPizza(Pizza pizza) {

        pizzariaDAO.save(pizza);
        return "Pizza adicionada com sucesso!";
    }
}
