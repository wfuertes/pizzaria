package com.matera.pizzaria.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.matera.pizzaria.model.Pizza;
import com.matera.pizzaria.repository.PizzaRepository;

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

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaRS(final PizzaRepository pizzaRepository) {

        this.pizzaRepository = pizzaRepository;
    }

    @ResponseBody
    @RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {

        return ResponseEntity.ok(pizzaRepository.save(pizza));
    }

    @ResponseBody
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pizza>> getPizzas() {

        return ResponseEntity.ok(pizzaRepository.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {

        return ResponseEntity.ok(pizzaRepository.findOne(id));
    }

    @ResponseBody
    @RequestMapping(method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza) {

        return ResponseEntity.ok(pizzaRepository.save(pizza));
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePizza(@PathVariable Long id) {

        pizzaRepository.delete(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
