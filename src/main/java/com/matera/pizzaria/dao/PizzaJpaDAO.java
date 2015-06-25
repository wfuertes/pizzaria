package com.matera.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matera.pizzaria.model.Pizza;

/**
 *
 *
 * @author wbatista
 */
@Primary
@Repository
@Transactional
public class PizzaJpaDAO implements PizzaDAO {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(final EntityManager em) {

        this.em = em;
    }

    @Override
    public Pizza save(Pizza pizza) {

        return em.merge(pizza);
    }

    @Override
    public Pizza update(Pizza pizza) {

        return save(pizza);
    }

    @Override
    public void delete(Long id) {

        em.createQuery("delete from Pizza where id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public Pizza findOne(Long id) {

        return em.find(Pizza.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pizza> findAll() {

        return em.createQuery("from Pizza order by name", Pizza.class).getResultList();
    }
}