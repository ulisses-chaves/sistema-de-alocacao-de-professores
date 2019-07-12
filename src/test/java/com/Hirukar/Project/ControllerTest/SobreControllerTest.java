package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.SobreController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SobreControllerTest {
    private SobreController sobremesa = new SobreController();

    @Test
    public void SobreTest(){
        String resultado = sobremesa.sobre();
        Assert.assertEquals(resultado,"sobre");
    }
}
