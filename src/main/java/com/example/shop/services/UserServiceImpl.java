package com.example.shop.services;

import com.example.shop.bll.User;
import com.example.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public void addUser (User user) {
        userRepository.save(user);
    }

    public User getUserByEmail (String email) {
        User user = new User();
        user.setEmail(email);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<User> example = Example.of(user, customExampleMatcher);

        return userRepository.findAll(example).get(0);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void updateUser (User user) {
        userRepository.save(user);
    }
}
