/*
 * Copyright 2015, Charter Communications, All rights reserved.
 */
package com.matera.pizzaria.service;

import com.matera.pizzaria.model.User;
import com.matera.pizzaria.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author wbatista
 */
@Service
public class PizzariaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public PizzariaUserDetailsService(final UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
}
