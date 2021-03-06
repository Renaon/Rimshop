package com.example.Rimshop.controller;

import com.example.Rimshop.entity.User;
import com.example.Rimshop.exceptions.UserExistsException;
import com.example.Rimshop.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserSevice userSevice;

    @GetMapping("/register")
    public String register(Model model){
        User userForm = new User();
        model.addAttribute("user", userForm);
        return "register";
    }


    //знаю шо небезопасно, на реальном проекте этого метода не будет
    @GetMapping("/adminReg")
    public String adminRegister(Model model){
        User userForm = new User();
        userForm.setRole_id(userSevice.getRoleById(2L));
        model.addAttribute("user", userForm);
        return "register";
    }

    @RequestMapping("/register_success")
    public String register(@ModelAttribute("user") User userForm){
        try {
            userSevice.saveUser(userForm);
        }catch (UserExistsException e){
            return "regErr";
        }

        return "success";
    }
}
