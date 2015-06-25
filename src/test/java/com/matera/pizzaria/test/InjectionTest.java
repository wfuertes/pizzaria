package com.matera.pizzaria.test;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.matera.pizzaria.dao.PizzaDAO;
import com.matera.pizzaria.model.Pizza;
import com.matera.pizzaria.service.PizzaService;

/**
 *
 *
 * @author wbatista
 */
public class InjectionTest {

    public static void main(String[] args) {

        try (
            ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring/app-context.xml")) {

            // Criando umas Pizzas
            Pizza pizza = new Pizza();
            pizza.setName("Luzitana II");
            pizza.setPrice(new BigDecimal("39.80"));
            
            Pizza pizza2 = new Pizza();
            pizza2.setName("Paulista");
            pizza2.setPrice(new BigDecimal("29.50"));

            // Pegando uma instancia de PizzaService
            PizzaService service = context.getBean(PizzaService.class);

            // Usando PizzaService
            service.addNewPizza(pizza);
            service.addNewPizza(pizza2);

            // Pegando uma instancia de PizzaDAO
            PizzaDAO dao = context.getBean(PizzaDAO.class);

            // Buscando todos as Pizzas
            dao.findAll().stream().forEach(p -> System.out.println(p.getName()));
        }
    }
}
