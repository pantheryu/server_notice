package com.kevin.test;

import com.kevin.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by spirit on 2016/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/ApplicationContext.xml")
public class TestImportXml {

    @Autowired
    private User user;

    @Test
    public void testImportAppXml(){
        user.setId(1);
    }
}
