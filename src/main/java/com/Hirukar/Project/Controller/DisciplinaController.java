/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.UserDAO;
import com.Hirukar.Project.Models.Beans.Horarios__;
import java.io.IOException;
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
    static Horarios__ h = new Horarios__();
    static boolean esq = true,dir = true;
    
    public Horarios__[] init() throws IOException{
        Horarios__ horarios[] = new Horarios__[5];
        for(Horarios__ h : horarios)
            h = new Horarios__();
        
        return horarios;
    }
    @RequestMapping("/disciplinas")
    public String disciplinas() throws IllegalAccessException{
        System.out.println("diciplinado de forma errada");
       // ModelAndView mv = new ModelAndView("disciplinas");
        //mv.addObject("h", h);
        return "disciplinas";
    }
    
    @RequestMapping(value="/atualizarSlots", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String atualizarSlots(ModelMap map) throws IllegalAccessException{
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
    public ResponseEntity<String> alterarSlots(int n1,int n2) throws SQLException{
        System.out.println("\n.\n.{\nn1:"+n1+"\nn2:"+n2+"\n}");
        if(h.troca(n1, n2))
            return new ResponseEntity<>("OK",HttpStatus.OK);
        else
            return new ResponseEntity<>("troca não realizada",HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/horarios", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> formLogin(String login,String senha) throws SQLException{
        UserDAO dao = new UserDAO();
        ResponseEntity<String> re = null;
        System.out.println("login:"+login+";  senha:"+senha);
        if(dao.logar(login, senha) != null) 
            return new ResponseEntity<>("logado",HttpStatus.OK);
        return new ResponseEntity<>("login ou senha invalidos",HttpStatus.BAD_REQUEST);
    }
}
