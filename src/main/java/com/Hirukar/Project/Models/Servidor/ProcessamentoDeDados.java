/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Servidor;

import com.Hirukar.Project.Models.Beans.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author RODEMARCK
 */
public class ProcessamentoDeDados {
    public static List<PoolDeUsuarios> usuariosConectados = new ArrayList<>();
    private static Random rng = new Random();
    public static int inicio = 9;
    public static int fim = 7;
    public static boolean emUso = false;
    public static boolean emAlteracao = false;
    public static boolean serverOn = true;
    
    
    public static void limpeza(){
        new Thread(() -> {
            while(serverOn){
                try{Thread.sleep(30000);
                }catch(InterruptedException e){}
                usuariosConectados.removeIf(PoolDeUsuarios :: acabouCessao);
            }
        }).start();         
    }
    
    public static void atualizaChaves(){
        new Thread(() -> {
            while(serverOn){
                try{Thread.sleep(900000);
                }catch(InterruptedException e){}
                while(emUso){
                    try{Thread.sleep(1);
                    }catch(InterruptedException e){}
                }
                emAlteracao=true;
                
                inicio = rng.nextInt(10);
                fim = rng.nextInt(10);
                
                emAlteracao=false;
            }
        }).start();
    }
    
    public static String createUrl(User u){
        while(emAlteracao);
        emUso = true;
        String url = criarPrefixo() + u.getId() + criarSufixo();
        usuariosConectados.add(new PoolDeUsuarios(u, url));
        emUso = false;
        return "";
    }
    
    public static User getUser(String url){
        for(PoolDeUsuarios x : usuariosConectados)
            if(x.getUrl().equals(url))
                return x.getUsuario();
        return null;
            
    }
    
    public static String criarPrefixo(){
        int t = rng.nextInt(11)+4;
        int aux;
        String s ="";
        for(int x=0 ; x<t ; x++){
            do
                aux = rng.nextInt(10); 
            while(aux != inicio);
            s+=aux;
        }
        s+=inicio;
        return s;
    }    
    
    public static String criarSufixo(){
        int t = rng.nextInt(11)+4;
        int aux;
        String s =""+fim;
        for(int x=0 ; x<t ; x++){
            do
                aux = rng.nextInt(10); 
            while(aux != fim);
            s+=aux;
        }
        return s;
    }    
}
