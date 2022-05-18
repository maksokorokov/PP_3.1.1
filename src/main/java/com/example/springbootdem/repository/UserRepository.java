package com.example.springbootdem.repository;

import com.example.springbootdem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
