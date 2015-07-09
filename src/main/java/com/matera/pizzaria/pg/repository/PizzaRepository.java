package com.matera.pizzaria.pg.repository;

import com.matera.pizzaria.pg.model.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author wbatista
 */
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
