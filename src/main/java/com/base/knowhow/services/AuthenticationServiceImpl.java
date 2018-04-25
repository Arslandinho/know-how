package com.base.knowhow.services;

import com.base.knowhow.models.User;
import com.base.knowhow.repositories.UserRepository;
import com.base.knowhow.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl currentUserDetails = (UserDetailsImpl)authentication.getPrincipal();
        User currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        System.out.println("CURRENT USER ID IS " + currentUserId);
        return userRepository.getOne(currentUserId);
    }

}
