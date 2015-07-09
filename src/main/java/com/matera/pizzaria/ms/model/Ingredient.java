/*
 * Copyright 2015, WFB, All rights reserved.
 */
package com.matera.pizzaria.ms.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 *
 * @author Willian
 */
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String measurement;
    private int quantity;

    /**
     * @return the id
     */
    public Long getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {

        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    /**
     * @return the measurement
     */
    public String getMeasurement() {

        return measurement;
    }

    /**
     * @param measurement the measurement to set
     */
    public void setMeasurement(String measurement) {

        this.measurement = measurement;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {

        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

}
