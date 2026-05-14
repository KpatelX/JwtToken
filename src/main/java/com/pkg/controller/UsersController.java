package com.pkg.controller;

import com.pkg.dto.UsersDto;
import com.pkg.entity.Users;
import com.pkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * The type Users controller.
 */
@RestController()
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    /**
     * Add user string.
     *
     * @param usersDto the users dto
     * @return the string
     */
    @PostMapping("/addUser")
    public String addUser(@RequestBody UsersDto usersDto) {
        return userService.addUser(usersDto);
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        return userService.getUsers();
    }
}
