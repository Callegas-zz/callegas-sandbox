package com.callegasdev.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import com.callegasdev.view.OperationsTracking;

public class Sub implements Operation {

    @Autowired
    private OperationsTracking operationsTracking;

    public Sub(OperationsTracking operationsTracking) {
        this.operationsTracking = operationsTracking;
    }


    @Override
    public Double execute(Double x, Double y) {
        Double total = 0.0;
        try {
            total = x - y;
            operationsTracking.setSuccessLog("The sub of " + x + " - " + y + " is: " + total);
        } catch (Exception e) {
            operationsTracking.setErrorLog("Invalid operation!");
        }
        return total;
    }
}
