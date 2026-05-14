package com.pkg.controller;

import com.pkg.dto.UsersDto;
import com.pkg.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Login users dto.
     *
     * @param userDto the user dto
     * @return the users dto
     */
    @PostMapping("/login")
    public UsersDto login(@RequestBody UsersDto userDto) {
        return authService.login(userDto);
    }

    /**
     * Logout string.
     *
     * @param userDto the user dto
     * @return the string
     */
    @PostMapping("/logout")
    public String logout(@RequestBody UsersDto userDto) {
        return authService.logout(userDto.getJwtToken());
    }
}
