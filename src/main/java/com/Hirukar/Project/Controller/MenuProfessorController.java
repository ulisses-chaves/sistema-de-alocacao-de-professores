/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RODEMARCK
 */
public class MenuProfessorController {
    @RequestMapping("/menuProfesso")
    public ModelAndView menuProfesso(){
        return new ModelAndView("menuProfesso");
    }
}
