package com.matera.pizzaria.dao;

import com.matera.pizzaria.model.Pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author wbatista
 */
@Repository
public class PizzaMemoriaDAO implements PizzaDAO {

    private static final Map<Long, Pizza> pizzas = new HashMap<>();

    @Override
    public void save(Pizza pizza) {

        if (pizza.getId() == null) {
            pizza.setId((long) pizzas.size() + 1);
        }
        pizzas.put(pizza.getId(), pizza);
    }

    @Override
    public void update(Pizza pizza) {

        this.save(pizza);
    }

    @Override
    public void delete(Long id) {

        pizzas.remove(id);
    }

    @Override
    public Pizza findOne(Long id) {

        return pizzas.get(id);
    }

    @Override
    public List<Pizza> findAll() {

        return new ArrayList<>(pizzas.values());
    }
}
