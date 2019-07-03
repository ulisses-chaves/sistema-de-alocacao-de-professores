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
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;
import com.Hirukar.Project.Models.Users_.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RODEMARCK
 */
@RestController
public class VariavelController {
    @RequestMapping(value="/variavel/professores", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ArrayList<Professor> getProfessores() throws ClassNotFoundException, SQLException{
        return ProfessorDAO.listar();
    }
     
     
    @RequestMapping(value="/variavel/professores", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void putProfessores(Professor professor) throws ClassNotFoundException, SQLException{
        ProfessorDAO.cadastrar(professor);
    }
    
    
    @RequestMapping(value="/variavel/professores", method = RequestMethod.PATCH, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void patchProfessores(String login,Professor professor) throws ClassNotFoundException, SQLException{
        ProfessorDAO.atualiza(login, professor);
    }
    
    @RequestMapping(value="/variavel/professores", method = RequestMethod.DELETE, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void deleteProfessores(Professor professor){
        //
    }
    
   
    
    
    
    
     
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ArrayList<Disciplina__> getDisciplinas() throws ClassNotFoundException, SQLException{
        return DisciplinasDAO.listar();
    }
     
     
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> putDisciplina(String disciplina, String codigo,String area,String tipo) throws ClassNotFoundException, SQLException{
        System.out.println("sexo anal");
        Disciplina__ d = new Disciplina__(disciplina,codigo,TipoDisciplina.valueOf(tipo),Area.valueOf(area));
    	try{
    		DisciplinasDAO.cadastrar(d);
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.PATCH, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void patchDisciplina(String nome,Disciplina__ disciplina) throws ClassNotFoundException, SQLException{
        DisciplinasDAO.atualiza(nome, disciplina);
    }
    
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.DELETE, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void deleteDisciplina(Disciplina__ disciplina){
        
    }
    
   
     
}
