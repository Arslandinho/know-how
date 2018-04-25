package com.base.knowhow.services;

import com.base.knowhow.models.User;
import org.springframework.security.core.Authentication;


public interface AuthenticationService  {
    User getUserByAuthentication(Authentication authentication);
}
