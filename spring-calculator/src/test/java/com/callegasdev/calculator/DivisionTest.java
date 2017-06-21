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
public class DivisionTest {

    @Autowired
    Calculator calculator;


    @Test
    public void whenExecuteValidDivision(){
        Double x = 14.0;
        Double y = 2.0;
        String operation = "/";
        Double result = 7.0;
        assertEquals(result , calculator.executeCalculator( x, y, operation ));

    }

    @Test
    public void whenYouTryToDivideByZero(){
        Double x = 140.0;
        Double y = 0.0;
        String operation = "/";
        Double result = 0.0;
        assertEquals(result , calculator.executeCalculator( x, y, operation ));
    }
}
