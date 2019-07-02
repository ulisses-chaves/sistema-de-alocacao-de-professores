package com.Hirukar.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/deslogar")
    public String deslogar(HttpSession session){
        System.out.println("deslogando");
        session.invalidate();
        return "redirect: /";
    }
}
