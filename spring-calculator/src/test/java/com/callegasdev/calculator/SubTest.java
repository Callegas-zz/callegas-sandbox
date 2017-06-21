package com.callegasdev.calculator;

import com.callegasdev.controller.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class SubTest {

    @Autowired
    Calculator calculator;

    @Test
    public void whenExecuteValidSub(){
        Double x = 12.0;
        Double y = 2.0;
        String operation = "-";
        Double result = 10.0;
        assertEquals(result , calculator.executeCalculator( x, y, operation ));


    }
}
