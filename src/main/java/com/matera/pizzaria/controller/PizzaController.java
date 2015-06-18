package com.matera.pizzaria.controller;

import com.matera.pizzaria.model.Pizza;
import com.matera.pizzaria.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 *
 * @author wbatista
 */
@Controller
@RequestMapping("pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaController(final PizzaRepository pizzaRepository) {

        this.pizzaRepository = pizzaRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView toPizzas(ModelAndView view) {

        view.setViewName("index");
        view.getModel().put("pagePath", "pizzas.jsp");
        view.getModel().put("pizzas", pizzaRepository.findAll());
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPizza(Pizza pizza) {

        pizzaRepository.save(pizza);
        return "redirect:/pizza";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updatePizza(Pizza pizza) {

        pizzaRepository.save(pizza);
        return "redirect:/pizza";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getPizza(@PathVariable("id") Long id, ModelAndView view) {

        view.setViewName("index");
        view.getModel().put("pagePath", "pizzas.jsp");
        view.getModel().put("pizza", pizzaRepository.findOne(id));
        view.getModel().put("pizzas", pizzaRepository.findAll());
        return view;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deletePizza(@PathVariable("id") Long id) {

        pizzaRepository.delete(id);
        return "redirect:/pizza";
    }
}
