package com.lan.demo.config;

import com.lan.demo.filter.JwtAuthenticationFilter;
import com.lan.demo.filter.JwtLoginFilter;
import com.lan.demo.handle.AuthEntryPoint;
import com.lan.demo.handle.RestAuthenticationAccessDeniedHandler;
import com.lan.demo.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: Lan
 * @date: 2019/4/8 15:22
 * @description:security配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/user/hello").permitAll()
                .antMatchers("/user/logout").permitAll()
                .anyRequest().authenticated()
                .anyRequest()
                .access("@rbacauthorityservice.hasPermission(request,authentication)")
                .and()
                .addFilter(new JwtLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .exceptionHandling().accessDeniedHandler(new RestAuthenticationAccessDeniedHandler())
                .authenticationEntryPoint(new AuthEntryPoint());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
