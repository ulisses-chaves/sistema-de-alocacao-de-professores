/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author RODEMARCK
 */
@Controller
public class CadastrarController {
    @RequestMapping("/cadastroProfessor")
    public String cadastroProfessor(){
        return "cadastroProfessor";
    }
    @RequestMapping("/cadastroDisciplina")
    public String cadastroDisciplina(@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null  || userDetails.getAuthorities().toArray()[0].toString().equals(""))
            return "redirect:/";
        return "cadastroDisciplina";
    }
}
