package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.DisciplinaController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisciplinaControllerTest {
    private DisciplinaController disciplinasteste = new DisciplinaController();

    @Test
    public void discplinaTest()  throws IllegalAccessException{
        ModelAndView s = disciplinasteste.disciplinas();
        if(s == null)
            System.out.println("nullo!!!!!");
        Assert.assertEquals(s.getModel(),new ModelAndView("h").getModel());
        ModelAndView sTest = new ModelAndView("disciplinas");
       // s.addObject("h", h);
        Assert.assertEquals(s.getModel(),sTest.getModel());
    }
}
