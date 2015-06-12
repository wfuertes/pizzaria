package com.matera.pizzaria.controller;

import com.matera.pizzaria.dao.PizzaDAO;
import com.matera.pizzaria.model.Pizza;

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

    private final PizzaDAO pizzaDAO;

    @Autowired
    public PizzaController(final PizzaDAO pizzaDAO) {

        this.pizzaDAO = pizzaDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView toPizzas(ModelAndView view) {

        view.setViewName("pizza/home");
        view.getModel().put("pizzas", pizzaDAO.findAll());
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addPizza(Pizza pizza) {

        pizzaDAO.save(pizza);
        return "redirect:/pizza";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updatePizza(Pizza pizza) {

        pizzaDAO.update(pizza);
        return "redirect:/pizza";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getPizza(@PathVariable("id") Long id, ModelAndView view) {

        view.setViewName("pizza/home");
        view.getModel().put("pizza", pizzaDAO.findOne(id));
        view.getModel().put("pizzas", pizzaDAO.findAll());
        return view;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deletePizza(@PathVariable("id") Long id) {

        pizzaDAO.delete(id);
        return "redirect:/pizza";
    }
}
