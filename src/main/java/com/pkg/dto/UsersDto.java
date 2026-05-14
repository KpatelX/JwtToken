package com.pkg.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

/**
 * The type Users dto.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private String role;

    @JsonProperty("jwt_token")
    private String jwtToken;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsersDto usersDto = (UsersDto) o;
        return Objects.equals(id, usersDto.id) && Objects.equals(firstName, usersDto.firstName) && Objects.equals(middleName, usersDto.middleName) && Objects.equals(lastName, usersDto.lastName) && Objects.equals(userName, usersDto.userName) && Objects.equals(password, usersDto.password) && Objects.equals(role, usersDto.role) && Objects.equals(jwtToken, usersDto.jwtToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, userName, password, role, jwtToken);
    }
}
