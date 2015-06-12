package com.matera.pizzaria.dao;

import com.matera.pizzaria.model.Pizza;

import java.util.List;

/**
 *
 *
 * @author wbatista
 */
public interface PizzaDAO {

    void save(Pizza pizza);

    void update(Pizza pizza);

    void delete(Long id);

    Pizza findOne(Long id);

    List<Pizza> findAll();
}
