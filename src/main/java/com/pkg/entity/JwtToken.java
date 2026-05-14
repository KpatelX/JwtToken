package com.pkg.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "jwt_token")
public class JwtToken {

    @Id
    @Field("_id")
    @JsonProperty("id")
    private String id;

    @Field("jwt_token")
    @JsonProperty("jwt_token")
    private String jwtToken;

    @Field("created_date")
    @JsonProperty("created_date")
    private Date createdDate;

    @Field("is_expired")
    @JsonProperty("is_expired")
    private Boolean isExpired;
}