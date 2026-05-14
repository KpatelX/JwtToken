package com.pkg.service.userServiceImpl;

import com.pkg.entity.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * The type Token blacklist service.
 */
@Service
public class TokenBlacklistService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Add Jwt token.
     *
     * @param token the token
     */
    public void addJwtToken(String token) {
        JwtToken saveJwtToken = new JwtToken();
        saveJwtToken.setJwtToken(token);
        saveJwtToken.setCreatedDate(new Date());
        saveJwtToken.setIsExpired(Boolean.FALSE);
        mongoTemplate.insert(saveJwtToken);
    }

    /**
     * Expire token.
     *
     * @param jwtToken the token
     */
    public void expireToken(String jwtToken) {
        mongoTemplate.findAndModify(new Query(Criteria.where("jwt_token").is(jwtToken)), new Update().set("is_expired", Boolean.TRUE), JwtToken.class);
    }

    /**
     * Is active boolean.
     *
     * @param jwtToken the jwt token
     * @return the boolean
     */
    public boolean isActive(String jwtToken) {
        JwtToken existingJwtToken = mongoTemplate.findOne(new Query(Criteria.where("jwt_token").is(jwtToken).and("is_expired").is(Boolean.FALSE)), JwtToken.class);
        return existingJwtToken != null ? Boolean.TRUE : Boolean.FALSE;
    }
}
