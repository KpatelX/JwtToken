package com.pkg.service.userServiceImpl;

import com.pkg.dto.UsersDto;
import com.pkg.service.AuthService;
import com.pkg.utility.DbUtils;
import com.pkg.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Auth service.
 */
@Service
public class AuthServiceImpl implements AuthService {

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
    public AuthServiceImpl(JwtUtil jwtUtil, TokenBlacklistService tokenBlacklistService) {
        this.jwtUtil = jwtUtil;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @Override
    public UsersDto login(UsersDto request) {
        UsersDto response = new UsersDto();
        if (dbUtils.checkUserNameNPasswordExist(request.getUserName(), request.getPassword())) {
            String jwtToken = jwtUtil.generateToken(request.getUserName());
            tokenBlacklistService.addJwtToken(jwtToken);
            response.setJwtToken(jwtToken);
            return response;
        }
        return response;
    }

    @Override
    public String logout(String jwtToken) {
        jwtToken = jwtToken.replace("Bearer ", "");
        if (jwtUtil.validateToken(jwtToken)) {
            if (!tokenBlacklistService.isActive(jwtToken)) {
                return "Token already invalidated";
            }
            tokenBlacklistService.expireToken(jwtToken);
            return "Logout successful";
        }
        return "Invalid token";
    }
}