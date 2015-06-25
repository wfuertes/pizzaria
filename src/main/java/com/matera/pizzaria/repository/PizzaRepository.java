package com.matera.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matera.pizzaria.model.Pizza;

/**
 *
 *
 * @author wbatista
 */
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
