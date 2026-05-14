package com.pkg.repository;

import com.pkg.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends MongoRepository<Users, String> {

    Optional<Users> findById(String username);
}