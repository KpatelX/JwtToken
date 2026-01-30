package com.pkg.service.userServiceImpl;

import com.pkg.entity.Users;
import com.pkg.repository.UserRepository;
import com.pkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Users> getUsers(String id) {
        Optional<Users> usersOptional = userRepository.findById(id);
        return usersOptional;
    }
}