package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.MenuSupervisor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuSupervisorTest {
    private MenuSupervisor supervisor = new MenuSupervisor();
    @Test
    public void supervisorTest(){
        ModelAndView mv = supervisor.menuSupervisor();
        if(mv == null)
            System.out.println("nullo!!!!!");
        Assert.assertEquals(mv.getModel(),new ModelAndView("menuSupervisor").getModel());
    }
}
