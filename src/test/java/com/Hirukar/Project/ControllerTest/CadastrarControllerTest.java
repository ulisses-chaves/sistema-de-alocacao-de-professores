package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.CadastrarController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest

public class CadastrarControllerTest {
    CadastrarController t = new CadastrarController();

    @Test
    public void cadastrarTest(){
        String s = t.cadastroProfessor();
        String r = t.cadastroDisciplina();
        assertEquals(s,"cadastroProfessor");
        assertEquals(r,"cadastroDisciplina");
    }

}
