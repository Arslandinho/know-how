package com.base.knowhow.repositories;

import com.base.knowhow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUsername(String email);

    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);
}
