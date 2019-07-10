/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.Ministra;
import com.Hirukar.Project.Models.Enums.Area;
import com.Hirukar.Project.Models.Enums.TipoDisciplina;
import com.Hirukar.Project.Models.Enums.TipoUsuario;
import com.Hirukar.Project.Models.Users_.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
     
     
    @RequestMapping(value="/variavel/professores", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> putProfessores(String cpf,String nome, String area,String login, String senha, String tipo) throws ClassNotFoundException, SQLException{
        System.out.println("chamei");
        Professor p = new Professor(cpf, nome, Area.valueOf(area.toUpperCase()), login,new BCryptPasswordEncoder().encode(senha), TipoUsuario.valueOf(tipo.toUpperCase()));
        try {
            ProfessorDAO.cadastrar(p);
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(ClassNotFoundException | SQLException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
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
     
     
    @RequestMapping(value="/variavel/disciplinas", method = RequestMethod.POST)
    public ResponseEntity<String> putDisciplina(String disciplina, String codigo,String area,String tipo) throws ClassNotFoundException, SQLException{
        Disciplina d = new Disciplina(disciplina,codigo,TipoDisciplina.valueOf(tipo),Area.valueOf(area));
    	try{
            System.out.println(d);
            DisciplinasDAO.cadastrar(d);
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(ClassNotFoundException | SQLException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
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
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value="/variavel/ministra", method = RequestMethod.GET)
    public ArrayList<Ministra> getAlocacoes(int anoLetivo,int cpf) throws ClassNotFoundException, SQLException{
        return DisciplinasDAO.listarAlocacoes(anoLetivo, cpf);
    }
     
     
    @RequestMapping(value="/variavel/ministra", method = RequestMethod.POST)
    public ResponseEntity<String> postAlocacoes(String disciplina, String codigo,String area,String tipo) throws ClassNotFoundException, SQLException{
        Disciplina d = new Disciplina(disciplina,codigo,TipoDisciplina.valueOf(tipo),Area.valueOf(area));
    	try{
            System.out.println(d);
            DisciplinasDAO.cadastrar(d);
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(ClassNotFoundException | SQLException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
    
    
    @RequestMapping(value="/variavel/ministra", method = RequestMethod.PATCH)
    public void patchAlocacoes(String nome,Disciplina disciplina) throws ClassNotFoundException, SQLException{
        DisciplinasDAO.atualiza(nome, disciplina);
    }
    
    @RequestMapping(value="/variavel/ministra", method = RequestMethod.DELETE)
    public void deleteAlocacoes(Disciplina disciplina){
        //
    }

    @RequestMapping(value="/variavel/preferencia", method = RequestMethod.POST)
    public ResponseEntity<String> definirPreferencia(int cpf, int idDisciplina1, int idDisciplina2){
        try{
            ProfessorDAO.definirPreferencia(cpf, idDisciplina1, idDisciplina2);
            return new ResponseEntity<>("Registrado com sucesso",HttpStatus.OK);
        }catch(ClassNotFoundException | SQLException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


}
