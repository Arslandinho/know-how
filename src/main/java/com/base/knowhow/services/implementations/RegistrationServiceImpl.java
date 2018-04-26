package com.base.knowhow.services.implementations;

import com.base.knowhow.forms.UserRegistrationForm;
import com.base.knowhow.models.User;
import com.base.knowhow.repositories.UserRepository;
import com.base.knowhow.security.enums.Role;
import com.base.knowhow.services.RegistrationService;
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
        User newUser = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .secondName(userForm.getSecondName())
                .role(Role.USER)
                .build();

        userRepository.save(newUser);
    }
}
