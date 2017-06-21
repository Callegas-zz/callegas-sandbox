package com.callegasdev.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import com.callegasdev.view.OperationsTracking;

public class Pow implements Operation {

    @Autowired
    private OperationsTracking operationsTracking;

    public Pow(OperationsTracking operationsTracking) {
        this.operationsTracking = operationsTracking;
    }

    @Override
    public Double execute(Double x, Double y) {
        Double total = 0.0;
        try {
            total = Math.pow(x, y);
            operationsTracking.setSuccessLog("The pow of " + x + " ^ " + y + " is: " + total);
        } catch (Exception e) {
            operationsTracking.setErrorLog("Invalid operation!");
        }
        return total;
    }
}
