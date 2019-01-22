package com.example.sweater.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Sanya on 22.01.2019.
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
