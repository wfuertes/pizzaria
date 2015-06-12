package com.matera.pizzaria.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.matera.pizzaria.dao.PizzaDAO;
import com.matera.pizzaria.model.Pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author wbatista
 */
@Controller
@RequestMapping("/api/pizza")
public class PizzaRS {

    private final PizzaDAO dao;

    @Autowired
    public PizzaRS(final PizzaDAO dao) {

        this.dao = dao;
    }

    @ResponseBody
    @RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {

        return ResponseEntity.ok(dao.save(pizza));
    }

    @ResponseBody
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pizza>> getPizzas() {

        return ResponseEntity.ok(dao.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {

        return ResponseEntity.ok(dao.findOne(id));
    }

    @ResponseBody
    @RequestMapping(method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza) {

        return ResponseEntity.ok(dao.update(pizza));
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePizza(@PathVariable Long id) {

        dao.delete(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
