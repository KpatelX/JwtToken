package com.pkg.service;

import com.pkg.entity.Users;

import java.util.Optional;

public interface UserService {
    public Optional<Users> getUsers(String id);
}