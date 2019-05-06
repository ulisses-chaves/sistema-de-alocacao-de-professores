/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author RODEMARCK
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static final String[] ARTEFATOS  =  {
            "/css/**",
            "/img/**",
            "/fonts/**",
            "/js/**",
        };
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
            .authorizeRequests()
                .antMatchers(ARTEFATOS).permitAll()
                .antMatchers("/cadastroProfessor").hasAnyRole("SUPERVISOR","COORDENADOR")
                .antMatchers("/cadastroDisciplina").hasAnyRole("SUPERVISOR","COORDENADOR")
                .anyRequest()
                .authenticated()
            .and()
            .formLogin()
                .loginPage("/")
                .permitAll()
            .and()
            .logout()
                .permitAll();
    }
    
}
