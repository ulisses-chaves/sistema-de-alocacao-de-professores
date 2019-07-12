/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Beans.Periodo;
import com.Hirukar.Project.Models.Beans.Slots;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RODEMARCK
 */
@RestController
public class TesteController {
    @RequestMapping("teste")
    public ModelAndView teste() throws ClassNotFoundException, SQLException{
        ModelAndView mv = new ModelAndView("Teste");
        Periodo p = DisciplinasDAO.getPeriodo(1, 1);
        mv.addObject("h", p);
        return mv;
    }
}
