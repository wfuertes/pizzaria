package com.matera.pizzaria.ms.repository;

import com.matera.pizzaria.ms.model.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author wbatista
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
