package com.Hirukar.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author ULISSES
 */
@Controller
public class DefenirPreferenciasController {
    @RequestMapping("/preferencias")
    public ModelAndView DefenirPreferencias(){
        return new ModelAndView("preferencias");
    }
}
