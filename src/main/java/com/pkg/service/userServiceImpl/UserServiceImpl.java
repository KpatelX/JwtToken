package com.pkg.service.userServiceImpl;

import com.pkg.dto.UsersDto;
import com.pkg.entity.Users;
import com.pkg.service.UserService;
import com.pkg.utility.DbUtils;
import com.pkg.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Environment environment;

    @Autowired
    private DbUtils dbUtils;

    private final JwtUtil jwtUtil;

    private final TokenBlacklistService tokenBlacklistService;

    /**
     * Instantiates a new Auth service.
     *
     * @param jwtUtil               the jwt util
     * @param tokenBlacklistService the token blacklist service
     */
    public UserServiceImpl(JwtUtil jwtUtil, TokenBlacklistService tokenBlacklistService) {
        this.jwtUtil = jwtUtil;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @Override
    public String addUser(UsersDto usersDto) {
        if (usersDto == null) {
            return "Please enter valid user data..!!";
        }
        if (usersDto.getUserName() == null || usersDto.getUserName().isEmpty()) {
            return "Please enter user name.";
        }
        if (usersDto.getPassword() == null || usersDto.getPassword().isEmpty()) {
            return "Please enter password.";
        }
        try {
            if (!dbUtils.checkUserNameExist(usersDto.getUserName())) {
                if (usersDto != null && usersDto.getUserName() != null && !usersDto.getUserName().isEmpty()) {
                    Users user = new Users();
                    user.setUsername(usersDto.getUserName());
                    user.setPassword(usersDto.getPassword());
                    user.setFirstName(usersDto.getFirstName());
                    user.setMiddleName(usersDto.getMiddleName());
                    user.setLastName(usersDto.getLastName());
                    Users saved = mongoTemplate.insert(user);
                    if (saved != null && saved.getId() != null) {
                        return "User added successfully.";
                    }
                }
                return null;
            } else {
                return "User name is already exists.Please use another user name...!!!";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public List<Users> getUsers() {
        mongoTemplate.getDb().listCollectionNames().forEach(System.out::println);
        return mongoTemplate.findAll(Users.class);
    }
}