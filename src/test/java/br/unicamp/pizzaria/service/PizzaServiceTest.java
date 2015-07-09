/*
 * Copyright 2015, WFB,  All rights reserved.
 */
package br.unicamp.pizzaria.service;

import com.matera.pizzaria.ms.model.Ingredient;
import com.matera.pizzaria.pg.model.Pizza;
import com.matera.pizzaria.service.PizzaService;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 *
 *
 * @author Willian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/app-context.xml"})
public class PizzaServiceTest {

    @Autowired
    private PizzaService pizzaService;
    
    @Test
    public void testAddPizzaAndIngredient() {
        Pizza pizza = new Pizza();
        pizza.setName("Calabreza");
        pizza.setPrice(BigDecimal.valueOf(30.00));
        
        Ingredient ingredient = new Ingredient();
        ingredient.setMeasurement("Kg");
        ingredient.setName("Mussarela");
        ingredient.setPrice(BigDecimal.valueOf(19.90));
        ingredient.setQuantity(30);
        
        String addNewPizza = pizzaService.addNewPizza(pizza, ingredient);
        Assert.assertNotNull(addNewPizza);
    }
}
