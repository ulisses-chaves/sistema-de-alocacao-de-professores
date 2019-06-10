package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.TabelaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TabelaControllerTest {
    TabelaController t = new TabelaController();

    @Test
    public void testeTabela(){
        String s = t.tabela();
        assertEquals(s,"tabela");
    }
}
