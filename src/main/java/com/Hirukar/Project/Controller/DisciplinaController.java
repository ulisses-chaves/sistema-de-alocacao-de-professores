/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.GradeDeHorarios;
import com.Hirukar.Project.Models.Beans.QuadroDeHorarios;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<QuadroDeHorarios> quadros = grade.getQuadros();
        mv.addObject("quadros", quadros);
        return mv;
    }

    
}
;