package com.matera.pizzaria.controller;

import com.matera.pizzaria.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 *
 * @author wbatista
 */
@Controller
@RequestMapping({ "/", "index" })
public class IndexController {

    private final PizzaRepository repository;

    @Autowired
    public IndexController(final PizzaRepository repository) {

        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView toIndex(ModelAndView view) {

        view.setViewName("index");
        view.getModel().put("pagePath", "home.jsp");
        view.getModel().put("pizzas", repository.findAll());
        return view;
    }
}
