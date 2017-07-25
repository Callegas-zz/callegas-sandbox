package com.callegasdev.calculator;


import org.springframework.beans.factory.annotation.Autowired;
import com.callegasdev.view.OperationsTracking;

public class Division implements Operation {

    @Autowired
    private OperationsTracking operationsTracking;

    public Division(OperationsTracking operationsTracking) {
        this.operationsTracking = operationsTracking;
    }

    @Override
    public Double execute(Double x, Double y) {
        Double total = 0.0;

        try {
            if (x == 0 || y == 0)
                total = 0.0;
            else
                total = x / y;
            operationsTracking.setSuccessLog("The Division of " + x + " ÷ " + y + " is: " + total);

        }catch (Exception e) {
            operationsTracking.setErrorLog("Invalid operation!");
        }
        return total;
    }
}
