/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
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
            case "PROFESSOR":return new ModelAndView("redirect:/menuProfessor");
            case "COORDENADOR":return new ModelAndView("redirect:/menuCoordenador");
            case "SUPERVISOR":return new ModelAndView("redirect:/menuSupervisor");
        }
        return new ModelAndView("index");
    }
}
