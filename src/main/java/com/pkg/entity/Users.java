package com.pkg.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class Users {

    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private String role;
}