package com.callegasdev.calculator;

import com.callegasdev.controller.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class SumTest {

    @Autowired
    Calculator calculator;

    @Test
    public void whenExecuteValidSum(){
        Double x = 22.0;
        Double y = 21.0;
        String operation = "+";
        Double result = 43.0;
        assertEquals(result , calculator.executeCalculator( x, y, operation ));


    }
}
