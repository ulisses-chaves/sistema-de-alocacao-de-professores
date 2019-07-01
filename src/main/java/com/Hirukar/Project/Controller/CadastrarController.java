/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Disciplina__;
import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.Cursos;
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;
import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
import com.Hirukar.Project.Models.Users_.Professor;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author RODEMARCK
 */
@Controller
public class CadastrarController {
    @RequestMapping("/cadastroProfessor")
    public String cadastroProfessor(){
        return "cadastroProfessor";
    }
    @RequestMapping("/cadastroDisciplina")
    public String cadastroDisciplina(){
        return "cadastroDisciplina";
    }
    
   @RequestMapping(value = "/fazerCadastroProfessor", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> fazerCadastroProfessor(String nome,String login,String senha,String email,String codigo,String area,String tipo){
        System.out.println("cadastra um ze chamado:"+nome);
        Professor prof = new Professor(codigo, nome, Area.valueOf(area.toUpperCase()), login, new BCryptPasswordEncoder().encode(senha), TipoUsuario.valueOf(tipo.toUpperCase()));
        try{
            ProfessorDAO.cadastrar(prof);
            return new ResponseEntity<>("Cadastro realizado com sucesso!",HttpStatus.OK);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    
    
    @RequestMapping(value = "fazerCadastroDisciplina", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> fazerCadastroDisciplina(String disciplina, String codigo,int curso,int area,int tipo){
        try{
          //  new DisciplinasDAO().cadastrar(new Disciplina__ (disciplina,codigo,Cursos.getCurso(curso),Area.getArea(area),TipoDisciplina.getTipoDisciplina(tipo)));
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
