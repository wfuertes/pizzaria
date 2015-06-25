package com.matera.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.matera.pizzaria.model.User;
import com.matera.pizzaria.repository.UserRepository;

/**
 *
 *
 * @author wbatista
 */
@Controller
@RequestMapping("user")
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(final UserRepository repository) {

        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView toUsers(ModelAndView view) {

        view.setViewName("index");
        view.getModel().put("pagePath", "users.jsp");
        view.getModel().put("users", repository.findAll());
        return view;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(User user) {

        repository.save(user);
        return "redirect:/user";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateUser(User user) {

        repository.save(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("id") Long id, ModelAndView view) {

        view.setViewName("index");
        view.getModel().put("pagePath", "users.jsp");
        view.getModel().put("user", repository.findOne(id));
        view.getModel().put("users", repository.findAll());
        return view;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Long id) {

        repository.delete(id);
        return "redirect:/user";
    }
}
