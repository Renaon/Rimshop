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
public class InitialController {
    @Autowired
    UserSevice userSevice;

    @GetMapping("/initial_filling")
    public List<Role> init(){
        Role admin = new Role();
        Role user = new Role();
        user.setAuthority("user");
        admin.setAuthority("admin");
        userSevice.saveRole(user);
        userSevice.saveRole(admin);

        return userSevice.getAllRoles();
    }

    @GetMapping("/get_roles")
    public List<Role> getRoles(){
        return userSevice.getAllRoles();
    }

    @GetMapping("/create_admin")
    public List<User> createAdmin() {
        User firstAdmin = new User();
        firstAdmin.setPassword("admin");
        firstAdmin.setLogin("admin");
        firstAdmin.setRole(userSevice.getRoleById(2L));
        userSevice.saveUser(firstAdmin);
        return userSevice.getAllUsers();
    }

    @GetMapping("/get_users")
    public List<User> getAllUsers() {
        return userSevice.getAllUsers();
    }

    @GetMapping("/get_role")
    public Role getRole(){
        return userSevice.getRoleById(2L);
    }
}
