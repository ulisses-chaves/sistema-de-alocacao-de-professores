package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.DisciplinaController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisciplinaControllerTest {
    private DisciplinaController disciplinasteste = new DisciplinaController();



    @Test
    public void discplinaTest2() throws IllegalAccessException{
        String s = disciplinasteste.modalDisciplinas();
        assertEquals(s,"ResponseServer :: #modal-disciplina");
        String r = disciplinasteste.botaoNavegacaoDisciplina();
        assertEquals(r,"ResponseServer :: #navegaca-disciplina");
    }

}
