package com.base.knowhow.services.implementations;

import com.base.knowhow.models.User;
import com.base.knowhow.repositories.UserRepository;
import com.base.knowhow.security.details.UserDetailsImpl;
import com.base.knowhow.services.AuthenticationService;
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
        return userRepository.getOne(currentUserId);
    }

}
