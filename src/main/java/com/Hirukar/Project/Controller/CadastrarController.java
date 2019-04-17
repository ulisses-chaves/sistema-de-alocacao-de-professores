/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.LoginDAO;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> fazerCadastroProfessor(String name,String login,String senha,String email,String codigo,String area){
        LoginDAO dao = new LoginDAO();
        ResponseEntity<String> re = null;
        try{
            dao.cadastrarProfessor(name,login,senha,email,codigo,area);
            return new ResponseEntity<String>("Cadastro realizado com sucesso!",HttpStatus.OK);
        }catch(SQLException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/fazerCadastroDisciplina", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> fazerCadastroDisciplina(String disciplina,String codigo,String curso,String area,String obr,String opt){
        LoginDAO dao = new LoginDAO();
        ResponseEntity<String> re = null;
        try{
            dao.cadastrarDisciplina(disciplina,codigo,curso,area,obr,opt);
            return new ResponseEntity<String>("Cadastro realizado com sucesso!",HttpStatus.OK);
        }catch(SQLException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
        }
    }
}
