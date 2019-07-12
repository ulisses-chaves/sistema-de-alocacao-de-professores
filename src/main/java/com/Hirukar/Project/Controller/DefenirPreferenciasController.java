package com.Hirukar.Project.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ModelAndView DefenirPreferencias(@AuthenticationPrincipal UserDetails userDetails){
        if(userDetails == null  || userDetails.getAuthorities().toArray()[0].toString().equals(""))
            return new ModelAndView("redirect:/");
        return new ModelAndView("preferencias");
    }
}
