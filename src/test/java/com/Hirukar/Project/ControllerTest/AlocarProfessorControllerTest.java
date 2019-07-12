package com.Hirukar.Project.ControllerTest;

import org.junit.Assert;
import com.Hirukar.Project.Controller.AlocarProfessorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlocarProfessorControllerTest {
    private AlocarProfessorController alocar = new AlocarProfessorController();

    @Test
    public void alocarTest(){
        ModelAndView s = alocar.alocacaoProfessor();
        ModelAndView sTest = new ModelAndView("alocarProfessor");
        sTest.addObject("professores",null);
        sTest.addObject("aulas", new ArrayList<>());
        Assert.assertEquals(s.getModel(),sTest.getModel());
    }

}
