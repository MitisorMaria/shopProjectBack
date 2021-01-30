package com.example.shop.controllers;

import com.example.shop.bll.Product;
import com.example.shop.bll.User;
import com.example.shop.services.LoginService;
import com.example.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public User tryLogin(@RequestParam String email, @RequestParam String password) {
        if (loginService.login(email, password)) {
            User u = userService.getUserByEmail(email);
            return u;
        } else {
            return null;
        }
    }
}
