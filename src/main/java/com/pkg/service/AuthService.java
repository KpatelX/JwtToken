package com.pkg.service;

import com.pkg.dto.UsersDto;

/**
 * The interface Auth service.
 */
public interface AuthService {
    /**
     * Login users dto.
     *
     * @param usersDto the users dto
     * @return the users dto
     */
    UsersDto login(UsersDto usersDto);

    /**
     * Logout string.
     *
     * @param jwtToken the jwt token
     * @return the string
     */
    String logout(String jwtToken);
}