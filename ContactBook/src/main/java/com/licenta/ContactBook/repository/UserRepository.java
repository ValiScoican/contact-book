package com.licenta.ContactBook.repository;

import com.licenta.ContactBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Citeste despre Spring JPA convention.
    User findByUsername(String username);

    User findByEmail(String email);

}
