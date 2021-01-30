package com.example.shop.controllers;

import com.example.shop.bll.User;
import com.example.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("users")
    @ResponseBody
    public String getUserByEmail(@RequestParam String email) {
        User u = userService.getUserByEmail(email);
        String toReturn = u.getName() + " " + u.getSurname();
        return toReturn;
    }

    @PutMapping("users")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
