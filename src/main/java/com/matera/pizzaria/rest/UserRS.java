package com.matera.pizzaria.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.matera.pizzaria.model.User;
import com.matera.pizzaria.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author wbatista
 */
@Controller
@RequestMapping("/api/user")
public class UserRS {

    private final UserRepository userRepository;

    @Autowired
    public UserRS(final UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @ResponseBody
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {

        return ResponseEntity.ok(userRepository.findAll());
    }
}