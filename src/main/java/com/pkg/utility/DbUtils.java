package com.pkg.utility;

import com.pkg.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * The type Db utils.
 */
@Component
public class DbUtils {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Check user name exist boolean.
     *
     * @param userName the user name
     * @return the boolean
     */
    public Boolean checkUserNameExist(String userName) {
        return mongoTemplate.exists(new Query().addCriteria(Criteria.where("user_name").is(userName)), Users.class);
    }

    /**
     * Check user name n password exist boolean.
     *
     * @param userName the user name
     * @param password the password
     * @return the boolean
     */
    public Boolean checkUserNameNPasswordExist(String userName, String password) {
        return mongoTemplate.exists(new Query().addCriteria(Criteria.where("user_name").is(userName).and("password").is(password)), Users.class);
    }
}
