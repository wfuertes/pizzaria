package com.matera.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matera.pizzaria.model.User;

/**
 *
 *
 * @author wbatista
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
