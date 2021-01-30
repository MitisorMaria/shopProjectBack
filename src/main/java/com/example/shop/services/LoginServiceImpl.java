package com.example.shop.services;

import com.example.shop.bll.User;
import com.example.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserRepository userRepository;

    public boolean login (String emailAddress, String password) {
        User user = new User();
        user.setEmail(emailAddress);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<User> example = Example.of(user, customExampleMatcher);

        User u = userRepository.findAll(example).get(0);
        if (u.getPassword().equals(password)) {
            return true;
        } else return false;
    }

}
