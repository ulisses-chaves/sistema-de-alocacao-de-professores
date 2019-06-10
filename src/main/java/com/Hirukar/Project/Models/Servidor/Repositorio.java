/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Servidor;

import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Users_.Professor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author RODEMARCK
 */
public class Repositorio implements Serializable{
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Ministra> ministra = new ArrayList<>();

   
    
    
    
    
    private static Repositorio instancia;
    
    public static Repositorio get() throws IOException{
        if(instancia == null);
            ler();
        return instancia;
    }
    
    private static void ler() throws IOException{ 
         File f = null;
         FileInputStream fis = null;
         ObjectInputStream ois = null;
        try{
            f = new File("bancoDeDadaos\\repositorio.hirukar");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            instancia = (Repositorio) ois.readObject();
        }catch(IOException | ClassNotFoundException e){
            instancia = new Repositorio();
            salvar();
        }finally{
            if(fis !=null)
                fis.close();
            if(ois != null)
                ois.close();
        }
    }
    private static void salvar() throws  IOException{
        File f = new File("bancoDeDadaos\\repositorio.hirukar");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instancia);
        fos.close();
        oos.close();
    }
    
     public ArrayList<Ministra> getMinistra() {
        return ministra;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    
}
    