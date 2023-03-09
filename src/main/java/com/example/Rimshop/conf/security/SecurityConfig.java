package com.example.Rimshop.conf.security;

import com.example.Rimshop.service.UserSevice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserSevice userSevice;

//    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/add/**").hasAuthority("admin")
                .antMatchers("/user/**").hasAnyAuthority("client", "admin")
                .antMatchers("/cart/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll()
                .and().httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .headers().frameOptions().disable()
                .and().formLogin()
                .defaultSuccessUrl("http://localhost:8189");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userSevice);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

