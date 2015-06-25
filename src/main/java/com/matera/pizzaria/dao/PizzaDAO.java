package com.matera.pizzaria.dao;

import java.util.List;

import com.matera.pizzaria.model.Pizza;

/**
 *
 *
 * @author wbatista
 */
public interface PizzaDAO {

    Pizza save(Pizza pizza);

    Pizza update(Pizza pizza);

    void delete(Long id);

    Pizza findOne(Long id);

    List<Pizza> findAll();
}
