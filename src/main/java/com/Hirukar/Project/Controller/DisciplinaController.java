/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Periodo;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Hirukar.Project.Models.Enums.Cursos;
import com.Hirukar.Project.Models.Users_.Professor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RODEMARCK
 */
@Controller
public class  DisciplinaController {
    static boolean esq = true,dir = true;
    
    public Periodo[] init() throws SQLException, ClassNotFoundException {
        Periodo horarios[] = new Periodo[5];
        for(Periodo h : horarios)
            h = new Periodo();
        
        return horarios;
    }
    @RequestMapping("/disciplinas")
    public ModelAndView disciplinas() throws IllegalAccessException, SQLException, ClassNotFoundException {
        Periodo h = DisciplinasDAO.getPeriodo(1, 1);
        ModelAndView mv = new ModelAndView("disciplinas");
        mv.addObject("h", h);
        return mv;
    }
    
    @RequestMapping(value="/atualizarSlots", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String atualizarSlots(int idCurso, int nPeriodo, ModelMap map) throws IllegalAccessException,SQLException, ClassNotFoundException {
        Periodo h = DisciplinasDAO.getPeriodo(idCurso, nPeriodo);
        ArrayList<Professor> profesores = ProfessorDAO.listar();
        ArrayList<Integer> p = DisciplinasDAO.listarPeriodos(1);
        map.addAttribute("h", h);
        map.addAttribute("prof",profesores);
        map.addAttribute("p", p);
        map.addAttribute("esq", esq);
        map.addAttribute("dir", dir);
        return "ResponseServer :: #div-disciplinas";
    }
    
    @RequestMapping(value="/getModalDisciplina", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String modalDisciplinas() throws IllegalAccessException{
        return "ResponseServer :: #modal-disciplina";
    }
    
    @RequestMapping(value="/getBotaoNavegacaoDisciplina", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String botaoNavegacaoDisciplina() throws IllegalAccessException{
        return "ResponseServer :: #navegaca-disciplina";
    }
    
    @RequestMapping(value = "/alterarSlots", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> alterarSlots(int idCurso, int nPeriodo, int n1,int n2) {
        System.out.println("curso id:"+idCurso);
        System.out.println("periodo:"+nPeriodo);
        System.out.println("n1:"+n1);
        System.out.println("n2:"+n2);
        System.out.println("troca chamada");
        try{
            int idN1 = DisciplinasDAO.getIdHorarioDisciplina(idCurso,nPeriodo,n1);
            int idN2 = DisciplinasDAO.getIdHorarioDisciplina(idCurso,nPeriodo,n2);
            DisciplinasDAO.atualizaSlots(idN1,n2);
            DisciplinasDAO.atualizaSlots(idN2,n1);
            return new ResponseEntity<>("OK",HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("",HttpStatus.NOT_ACCEPTABLE);
        }
    }



    /*@RequestMapping(value = "/horarios", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> formLogin(String login,String senha) throws SQLException{
        ResponseEntity<String> re = null;
        System.out.println("login:"+login+";  senha:"+senha);
        if(dao.logar(login, senha) != null) 
            return new ResponseEntity<>("logado",HttpStatus.OK);
        return new ResponseEntity<>("login ou senha invalidos",HttpStatus.BAD_REQUEST);
    }*/
}
;