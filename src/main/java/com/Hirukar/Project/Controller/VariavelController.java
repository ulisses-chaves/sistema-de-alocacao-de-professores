/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Users_.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
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
    @RequestMapping(value="/professores", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ArrayList<Professor> getProfessores() throws ClassNotFoundException, SQLException{
        return ProfessorDAO.listar();
    }
     
     
    @RequestMapping(value="/professores", method = RequestMethod.PUT, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void putProfessores(Professor professor) throws ClassNotFoundException, SQLException{
        ProfessorDAO.cadastrar(professor);
    }
    
    
    @RequestMapping(value="/professores", method = RequestMethod.PATCH, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void patchProfessores(String login,Professor professor) throws ClassNotFoundException, SQLException{
        ProfessorDAO.atualiza(login, professor);
    }
    
    @RequestMapping(value="/professores", method = RequestMethod.DELETE, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public void deleteProfessores(Professor professor){
        //
    }
    
    @RequestMapping
    public ArrayList<Professor> get2Professores() throws ClassNotFoundException, SQLException{
        return ProfessorDAO.listar();
    }
     
}
