package com.base.knowhow.services;

import com.base.knowhow.forms.UserRegistrationForm;
import com.base.knowhow.models.User;
import com.base.knowhow.repositories.UserRepository;
import com.base.knowhow.security.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(UserRegistrationForm userForm) {
        User newUser = new User.Builder()
                .username(userForm.getLogin())
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .birthDate(userForm.getBirthDate())
                .role(Role.USER)
                .build();

        userRepository.save(newUser);
    }
}
