package com.matera.pizzaria.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matera.pizzaria.model.Pizza;

/**
 *
 *
 * @author wbatista
 */
@Repository
@Transactional
public class PizzaHibernateDAO implements PizzaDAO {

    private final SessionFactory factory;

    @Autowired
    public PizzaHibernateDAO(final SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public Pizza save(Pizza pizza) {

        Long id = (Long) factory.getCurrentSession().save(pizza);
        pizza.setId(id);
        return pizza;
    }

    @Override
    public Pizza update(Pizza pizza) {

        factory.getCurrentSession().update(pizza);
        return pizza;
    }

    @Override
    public void delete(Long id) {

        Pizza pizza = new Pizza();
        pizza.setId(id);
        factory.getCurrentSession().delete(pizza);
    }

    @Override
    @Transactional(readOnly = true)
    public Pizza findOne(Long id) {

        return (Pizza) factory.getCurrentSession().load(Pizza.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pizza> findAll() {

        return factory.getCurrentSession().createCriteria(Pizza.class).list();
    }
}
