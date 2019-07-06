/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;
import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
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
@RestController("/variavel")
public class VariavelController {
    @RequestMapping(value="/variavel/professores", method = RequestMethod.GET)
    public ArrayList<Professor> getProfessores() throws ClassNotFoundException, SQLException{
        return ProfessorDAO.listar();
    }
     
     
    @RequestMapping(value="/variavel/professores", method = RequestMethod.PUT, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void putProfessores(String cpf,String nome, String area,String login, String senha, String tipo) throws ClassNotFoundException, SQLException{
        Professor p = new Professor(cpf, nome, Area.valueOf(area.toUpperCase()), login, senha, TipoUsuario.valueOf(tipo.toUpperCase()));
        ProfessorDAO.cadastrar(p);
    }
    
    
    @RequestMapping(value="/variavel/professores", method = RequestMethod.PATCH, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void patchProfessores(String login,Professor professor) throws ClassNotFoundException, SQLException{
        //ProfessorDAO.atualiza(login, professor);
    }
    
    @RequestMapping(value="/variavel/professores", method = RequestMethod.DELETE, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void deleteProfessores(Professor professor){
        //
    }
    
   
    
    
    
    
     
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.GET)
    public ArrayList<Disciplina> getDisciplinas() throws ClassNotFoundException, SQLException{
        return DisciplinasDAO.listar();
    }
     
     
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.PUT)
    public ResponseEntity<String> putDisciplina(String disciplina, String codigo,String area,String tipo) throws ClassNotFoundException, SQLException{
        System.out.println("sexo anal");
        Disciplina d = new Disciplina(disciplina,codigo,TipoDisciplina.valueOf(tipo),Area.valueOf(area));
    	try{
    		DisciplinasDAO.cadastrar(d);
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.PATCH)
    public void patchDisciplina(String nome,Disciplina disciplina) throws ClassNotFoundException, SQLException{
        DisciplinasDAO.atualiza(nome, disciplina);
    }
    
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.DELETE)
    public void deleteDisciplina(Disciplina disciplina){
        //
    }
    
   
     
}
