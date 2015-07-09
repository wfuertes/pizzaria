package com.matera.pizzaria.service;

import com.matera.pizzaria.ms.model.Ingredient;
import com.matera.pizzaria.ms.repository.IngredientRepository;
import com.matera.pizzaria.pg.model.Pizza;
import com.matera.pizzaria.pg.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author wbatista
 */
@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaService(final PizzaRepository pizzaRepository, final IngredientRepository ingredientRepository) {

        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    public String addNewPizza(Pizza pizza, Ingredient ingredient) {

        pizzaRepository.save(pizza);
        ingredientRepository.save(ingredient);
        return "Pizza e ingrediente persistidos com sucesso!";
    }
}
