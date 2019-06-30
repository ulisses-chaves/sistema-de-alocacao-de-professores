/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Models.Beans.Slots;
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
    public ModelAndView teste(){
        ModelAndView mv = new ModelAndView("Teste");
        Slots slot = new Slots();
        mv.addObject("slots", slot);
        
        
        return mv;
    }
    
    /*@RequestMapping("/slotss")
    public Slots vai(){
        return new Slots();
    }*/
}
