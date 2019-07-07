/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Models.Beans.HorariosCurso;
import java.sql.SQLException;

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
    
    public HorariosCurso[] init() throws SQLException, ClassNotFoundException {
        HorariosCurso horarios[] = new HorariosCurso[5];
        for(HorariosCurso h : horarios)
            h = new HorariosCurso();
        
        return horarios;
    }
    @RequestMapping("/disciplinas")
    public ModelAndView disciplinas() throws IllegalAccessException, SQLException, ClassNotFoundException {
        HorariosCurso h = new HorariosCurso();
        ModelAndView mv = new ModelAndView("disciplinas");
        mv.addObject("h", h);
        return mv;
    }
    
    @RequestMapping(value="/atualizarSlots", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String atualizarSlots(ModelMap map) throws IllegalAccessException,SQLException, ClassNotFoundException {
        HorariosCurso h = new HorariosCurso();
        map.addAttribute("h", h);
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
    public ResponseEntity<String> alterarSlots(int n1,int n2) throws SQLException, ClassNotFoundException {
        HorariosCurso h = new HorariosCurso();
        System.out.println("\n.\n.{\nn1:"+n1+"\nn2:"+n2+"\n}");
        h.troca(n1, n2);
        return new ResponseEntity<>("OK",HttpStatus.OK);
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