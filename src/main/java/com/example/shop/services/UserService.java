package com.example.shop.services;

import com.example.shop.bll.User;

public interface UserService {
    void addUser (User user);
    void updateUser (User user);
    User getUserByEmail (String email);
}
