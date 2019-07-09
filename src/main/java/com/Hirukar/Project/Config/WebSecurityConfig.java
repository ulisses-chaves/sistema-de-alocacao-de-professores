/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Config;

import com.Hirukar.Project.Models.Enums.TipoUsuario;
import com.Hirukar.Project.Models.Users_.Detalhes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author RODEMARCK
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private static final String[] ARTEFATOS  =  {
            "/css/**",
            "/img/**",
            "/fonts/**",
            "/js/**",
            "/components/**",
            "/templates/**",
            "/resources/**"
    };

    @Autowired
    private Detalhes detalhes;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(detalhes).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(ARTEFATOS)
                    .permitAll()
                /*.antMatchers(
                        "/alocarProfessor",
                        "/cadastroDisciplina",
                        "/preferencias",
                        "/disciplinas",
                        "/atualizarSlots",
                        "/getModalDisciplina",
                        "/getBotaoNavegacaoDisciplina",
                        "/alterarSlots",
                        "/historicoAlocacao",
                        "/listaPreferencias",
                        "/menuCoordenador",
                        "/menuProfessor",
                        "/menuSupervisor",
                        "/regras",
                        "/variavel/professores",
                        "/variavel/disciplinas",
                        "/verificarAlocacoes")
                    .authenticated()*/
                .antMatchers("/listaPreferencias","/historicoAlocacao")
                    .hasAnyRole(TipoUsuario.PROFESSOR.name())
                .antMatchers("/cadastroProfessor","/sobre")
                    .permitAll()
            .and()
            .formLogin()
                .loginPage("/")
                    .permitAll()
            .and()
            .logout()
                .permitAll()
            .and()
            .csrf()
                .disable();
    }
    


}
