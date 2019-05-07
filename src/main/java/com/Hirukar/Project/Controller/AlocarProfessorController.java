/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Models.Beans.Disciplina__;
import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Users.Professor;
import java.util.ArrayList;
import java.util.List;
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
public class AlocarProfessorController {
    @RequestMapping("/alocarProfessor")
    public ModelAndView alocacaoProfessor(){
        ModelAndView mv = new ModelAndView("alocarProfessor");
        mv.addObject("professores",Professor.todosProfessores);
        mv.addObject("aulas", new ArrayList<>());
        return mv;
    }
    
    @RequestMapping(value="/atualizarAulas", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String requisicao(ModelMap map,int area){
        List<Disciplina__> v = new ArrayList<>();
        System.out.println("init");
        Disciplina__.inicializar().forEach((t) -> {
            System.out.println(t.getArea());
            if(t.getArea().getValue() == area){
                v.add(t);
                System.out.println("add");
            }
        });
        map.addAttribute("aulas", v);
        return "alocarProfessor :: #aulinhas";
    }
    
}
