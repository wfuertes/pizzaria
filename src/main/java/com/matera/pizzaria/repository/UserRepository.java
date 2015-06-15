package com.matera.pizzaria.repository;

import com.matera.pizzaria.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author wbatista
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
