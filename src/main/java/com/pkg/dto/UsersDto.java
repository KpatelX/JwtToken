package com.pkg.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private String role;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsersDto usersDto = (UsersDto) o;
        return Objects.equals(id, usersDto.id) && Objects.equals(username, usersDto.username) && Objects.equals(password, usersDto.password) && Objects.equals(role, usersDto.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }
}
