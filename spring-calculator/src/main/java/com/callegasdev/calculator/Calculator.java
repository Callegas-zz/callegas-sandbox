package com.callegasdev.calculator;

import java.util.Map;

public class Calculator {
    private Map<String, Operation> operationList;

    public Calculator(Map<String, Operation> operationList){
        this.operationList = operationList;
    }

    public Double executeCalculator(Double x, Double y, String operation){
        return operationList.get( operation ).execute(x, y);
    }
}
