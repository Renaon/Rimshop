package com.example.Rimshop.service;

import com.example.Rimshop.entity.Role;
import com.example.Rimshop.entity.User;
import com.example.Rimshop.exceptions.UserExistsException;
import com.example.Rimshop.repositories.RoleRepository;
import com.example.Rimshop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSevice implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

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

    public Optional<User> loadOptionalUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = loadOptionalUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getByLogin(String username) {
        return userRepository.loadUserByUsername(username);
    }
}
