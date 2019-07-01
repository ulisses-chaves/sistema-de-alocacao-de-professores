/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Enums.Cursos;
import com.Hirukar.Project.Models.Beans.Horarios__;
import com.Hirukar.Project.Models.Beans.Slots;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RODEMARCK
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public ModelAndView index(@AuthenticationPrincipal UserDetails userDetails){
        if(userDetails==null)
            return new ModelAndView("index");
        switch(userDetails.getAuthorities().toArray()[0].toString()){
            case "PROFESSOR":return new ModelAndView("menuProfessor");
            case "COORDENADOR":return new ModelAndView("menuCoordenador");
            case "SUPERVISOR":return new ModelAndView("menuSupervisor");
        }
        return new ModelAndView("index");
    }
}
