/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.UserDAO;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.GradeDeHorarios;
import com.Hirukar.Project.Models.Beans.Horario;
import com.Hirukar.Project.Models.Beans.Horarios__;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    static Horarios__ h = new Horarios__(5);
    @RequestMapping("/disciplinas")
    public ModelAndView disciplinas() throws IllegalAccessException{
        ModelAndView mv = new ModelAndView("disciplinas");
        mv.addObject("h", h);
        return mv;
    }
    
    @RequestMapping(value="/atualizarSlots", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String atualizarSlots(ModelMap map) throws IllegalAccessException{
        map.addAttribute("h", h);
        return "disciplinas :: #disciplinas";
    }
    
    @RequestMapping(value = "/alterarSlots", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> alterarSlots(int n1,int n2) throws SQLException{
        System.out.println("\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.{\nn1:"+n1+"\nn2:"+n2+"\n}");
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
            return new ResponseEntity<String>("logado",HttpStatus.OK);
        return new ResponseEntity<String>("login ou senha invalidos",HttpStatus.BAD_REQUEST);
    }
}
;