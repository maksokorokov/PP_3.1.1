package com.example.springbootdem.controller;

import com.example.springbootdem.model.User;
import com.example.springbootdem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }


//    @DeleteMapping("/user-delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.deleteById(id);
//        return "redirect:/users";
//    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.findById(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

//    @PutMapping("/user-update")
//    public String updateUser(@ModelAttribute("user") User user){
//        userService.saveUser(user);
//        return "redirect:/users";
//    }

}
