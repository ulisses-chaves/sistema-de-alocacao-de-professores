/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.LoginDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Professor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RODEMARCK
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        System.out.println("a1");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String formLogin(String login,String senha){
        System.out.println("a3");
        LoginDAO dao = new LoginDAO();
        System.out.println("login:"+login+";  senha:"+senha);
        try {
            if(dao.logar(login, senha))
                System.out.println("logado");
            else
                System.out.println("senha errada");
        } catch (SQLException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
    
    @RequestMapping("/professores")
    public ModelAndView listarProfessores(){
        ProfessorDAO dao = new ProfessorDAO();
        ModelAndView mv = new ModelAndView("tabela");
        Iterable<Professor> professores = dao.listarProfessores();
        mv.addObject("professores",professores);
        System.out.println("aaaaaaaaaa");
        return mv;
    }
    
}
