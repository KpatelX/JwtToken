package com.pkg.controller;

import com.pkg.dto.UsersDto;
import com.pkg.entity.Users;
import com.pkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public Optional<Users> getUsers(@PathVariable(value = "id") String id) {
        return userService.getUsers(id);
    }
}
