package com.example.Rimshop.service;

import com.example.Rimshop.entity.Role;
import com.example.Rimshop.entity.User;
import com.example.Rimshop.exceptions.UserExistsException;
import com.example.Rimshop.repositories.RoleRepository;
import com.example.Rimshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSevice {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(User user) throws UserExistsException {
        if (userRepository.loadUserByUsername(user.getUsername()) == null){
//            user.setRole_id(roleRepository.getReferenceById(2L));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));;
            userRepository.save(user);
        }else {
            throw new UserExistsException("User exist. Try to change your login");
        }
    }

    public Role getRoleById(Long id){
        return roleRepository.getReferenceById(id);
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
