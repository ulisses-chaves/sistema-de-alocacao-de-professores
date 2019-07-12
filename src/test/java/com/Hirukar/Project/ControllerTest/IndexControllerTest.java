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
        ModelAndView mv = index.index(null);
        Assert.assertEquals(mv.getModel(),new ModelAndView("index").getModel());

    }
}
