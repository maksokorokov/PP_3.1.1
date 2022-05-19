package com.example.springbootdem.service;

import com.example.springbootdem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitClass {
    private final UserService userService;

    public InitClass(UserService userService) {
        this.userService = userService;
    }

//    @PostConstruct
//    public void initMethod(){
//        userService.saveUser(new User("Ivan","Ivanov",22));
//        userService.saveUser(new User("Максим","Максимов",26));
//        userService.saveUser(new User("Petr","Petrov",5));
//    }
}
