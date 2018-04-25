package com.base.knowhow.validators;

import com.base.knowhow.forms.UserRegistrationForm;
import com.base.knowhow.models.User;
import com.base.knowhow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class RegistrationValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> someClass) {
        return someClass.getName().equals(UserRegistrationForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserRegistrationForm form = (UserRegistrationForm) target;

        Optional<User> existedUsername = userRepository.findByUsername(form.getLogin());
        Optional<User> existedEmail = userRepository.findByEmail(form.getEmail());

        if (existedUsername.isPresent()) {
            errors.reject("bad.login", "Логин занят");
        }
        if (existedEmail.isPresent()) {
            errors.reject("bad.email", "Электронный адрес занят");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Пустой логин");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Пустой пароль");
    }
}
