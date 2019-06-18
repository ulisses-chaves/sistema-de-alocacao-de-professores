package com.Hirukar.Project.ControllerTest;

import com.Hirukar.Project.Controller.IndexController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

public class IndexControllerTest {
    private IndexController index = new IndexController();

    @Test
    public void indexTest()throws SQLException{
        ModelAndView mv = index.indexS();
        ModelAndView mv2 = index.index();
        ModelAndView mv3 = index.disciplinas("aaa");
        if(mv == null)
            System.out.println("nullo!!!!!");
        Assert.assertEquals(mv.getModel(),new ModelAndView("index").getModel());
        Assert.assertEquals(mv2.getModel(),new ModelAndView("index").getModel());
       Assert.assertEquals(mv3.getModel(),new ModelAndView("logado").getModel());
    }
    @Test

    public void indexTest2(){
        IndexController t = new IndexController();
        String s = t.index_testes();
        assertEquals(s,"index_testes");
    }
}
