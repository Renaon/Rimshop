package com.example.Rimshop.controller;

import com.example.Rimshop.entity.Role;
import com.example.Rimshop.entity.User;
import com.example.Rimshop.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {
    @Autowired
    UserSevice userSevice;

    @GetMapping("/initial_filling")
    public String init(){
        Role admin = new Role();
        Role user = new Role();
        user.setAuthority("user");
        admin.setAuthority("admin");
        userSevice.saveRole(user);
        userSevice.saveRole(admin);

        User firstAdmin = new User();
        firstAdmin.setRole_id(admin);
        userSevice.saveUser(firstAdmin);
        return "success";
    }
}
