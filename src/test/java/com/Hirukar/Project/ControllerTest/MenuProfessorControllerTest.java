package com.Hirukar.Project.ControllerTest;
import com.Hirukar.Project.Controller.MenuProfessorController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MenuProfessorControllerTest {
        private MenuProfessorController professor = new MenuProfessorController();
    @Test
    public void ProfeTest(){
        ModelAndView mv = professor.menuProfesso();
        if(mv == null)
            System.out.println("nullo!!!!!");
        Assert.assertEquals(mv.getModel(),new ModelAndView("menuProfessor").getModel());
    }
}
