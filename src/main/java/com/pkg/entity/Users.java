package com.pkg.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The type Users.
 */
@Data
@Document(collection = "users")
public class Users {

    @Id
    @Field("_id")
    @JsonProperty("id")
    private String id;

    @JsonProperty("user_name")
    @Field("user_name")
    private String username;

    @JsonProperty("password")
    @Field("password")
    private String password;

    @JsonProperty("first_name")
    @Field("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    @Field("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    @Field("last_name")
    private String lastName;

    @JsonProperty("role")
    @Field("role")
    private String role;
}