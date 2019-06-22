/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Servidor.Repositorio;
import com.Hirukar.Project.Models.Users_.Professor;
import java.io.IOException;
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
    public ModelAndView alocacaoProfessor() throws IOException{
        ModelAndView mv = new ModelAndView("alocarProfessor");
        mv.addObject("professores",Repositorio.get().getProfessores());
        mv.addObject("aulas", new ArrayList<>());
        return mv;
    }
    
    @RequestMapping(value="/atualizarAulas", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String requisicao(ModelMap map,Area area) throws IOException{
        List<Disciplina> v = new ArrayList<>();
        Repositorio.get().getDisciplinas().forEach((t) -> {
            if(t.getArea() == area || t.getArea() == Area.FLUTUANTE)
                v.add(t);
        });
        map.addAttribute("aulas", v);
        return "alocarProfessor :: #aulinhas";
    }
    
}
