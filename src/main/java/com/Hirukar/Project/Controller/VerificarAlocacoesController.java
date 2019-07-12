package com.Hirukar.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*
* @author ULISSES
*/
@Controller
public class VerificarAlocacoesController {
	@RequestMapping("/verificarAlocacoes")
    public ModelAndView VerificarAlocacoes(){
        return new ModelAndView("verificarAlocacoes");
    }
}
