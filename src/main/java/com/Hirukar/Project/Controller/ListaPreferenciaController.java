package com.Hirukar.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*
* @author ULISSES
*/
@Controller
public class ListaPreferenciaController {
	@RequestMapping("/listaPreferencias")
    public ModelAndView ListaPreferencias(){
        return new ModelAndView("listaPreferencias");
    }
}
