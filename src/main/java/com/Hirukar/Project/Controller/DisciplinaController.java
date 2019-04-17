/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.LoginDAO;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.GradeDeHorarios;
import com.Hirukar.Project.Models.Beans.Horario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping("/disciplinas")
    public ModelAndView disciplinas(){
        ModelAndView mv = new ModelAndView("disciplinas");
        GradeDeHorarios grade = new GradeDeHorarios();
        List<Horario> quadros = grade.getQuadros();
        mv.addObject("quadros", quadros);
        return mv;
    }

    @RequestMapping(value = "/horarios", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> formLogin(String login,String senha) throws SQLException{
        LoginDAO dao = new LoginDAO();
        ResponseEntity<String> re = null;
        System.out.println("login:"+login+";  senha:"+senha);
        if(dao.logar(login, senha))
            return new ResponseEntity<String>("logado",HttpStatus.OK);
        return new ResponseEntity<String>("login ou senha invalidos",HttpStatus.BAD_REQUEST);
    }
}
;