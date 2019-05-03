/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Servidor;

import com.Hirukar.Project.Models.Beans.Users.User;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author RODEMARCK
 */
public class PoolDeUsuarios {
    private User usuario;
    private String url;
    private LocalDateTime tempoDeAcesso;

    public PoolDeUsuarios(User usuario, String url) {
        this.usuario = usuario;
        this.url = url;
        this.tempoDeAcesso = LocalDateTime.now();
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        atualiza();
    }

    public boolean acabouCessao() {
        return Duration.between(tempoDeAcesso, LocalDateTime.now()).getSeconds() > 300;
    }

    public void atualiza() {
        this.tempoDeAcesso = LocalDateTime.now();
    }
    
        
}
