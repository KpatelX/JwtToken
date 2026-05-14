package com.pkg.service;

import com.pkg.dto.UsersDto;
import com.pkg.entity.Users;

import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Add user string.
     *
     * @param usersDto the users dto
     * @return the string
     */
    String addUser(UsersDto usersDto);

    /**
     * Gets users.
     *
     * @return the users
     */
    List<Users> getUsers();
}