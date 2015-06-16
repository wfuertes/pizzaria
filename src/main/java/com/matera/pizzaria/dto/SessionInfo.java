package com.matera.pizzaria.dto;

import com.matera.pizzaria.model.User;

/**
 *
 *
 * @author wbatista
 */
public class SessionInfo {

    private String id;
    private User user;

    /**
     * @return the id
     */
    public String getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {

        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser() {

        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {

        this.user = user;
    }

}
