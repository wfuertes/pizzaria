package com.matera.pizzaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 *
 * @author wbatista
 */
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "id")
    private String authority;
    private String description;

    /**
     * @return the authority
     */
    @Override
    public String getAuthority() {

        return authority;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {

        this.authority = authority;
    }

    /**
     * @return the description
     */
    public String getDescription() {

        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {

        this.description = description;
    }

}
