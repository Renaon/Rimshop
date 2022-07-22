package com.example.Rimshop.controller;

import com.example.Rimshop.entity.Role;
import com.example.Rimshop.entity.User;
import com.example.Rimshop.service.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InitialController {
    UserSevice userSevice;

    @GetMapping("/initial_filling")
    public List<Role> init(){
        Role admin = new Role();
        Role user = new Role();
        user.setAuthority("user");
        admin.setAuthority("admin");
        userSevice.saveRole(user);
        userSevice.saveRole(admin);

        User firstAdmin = new User();
        firstAdmin.setRole_id(admin);
        userSevice.saveUser(firstAdmin);
        return userSevice.getAllRoles();
    }

    @GetMapping("/get_roles")
    public List<Role> getRoles(){
        return userSevice.getAllRoles();
    }
}
