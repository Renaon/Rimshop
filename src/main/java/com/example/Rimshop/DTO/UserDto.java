package com.example.Rimshop.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String login;
    private final String password;
    private final RoleDto role;
}
