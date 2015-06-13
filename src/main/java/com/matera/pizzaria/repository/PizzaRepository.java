package com.matera.pizzaria.repository;

import com.matera.pizzaria.model.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author wbatista
 */
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
