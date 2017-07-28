package com.callegasdev.view;

import com.callegasdev.controller.CalculatorOperations;
import com.callegasdev.database.ListHistory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class MainMenu {

    @Autowired
    private OperationsTracking operationsTracking;
    private CalculatorOperations calculatorOperations;
    private Scanner input;
    private ListHistory listHistory;

    public MainMenu(OperationsTracking operationsTracking, CalculatorOperations calculatorOperations, Scanner input, ListHistory listHistory) {
        this.operationsTracking = operationsTracking;
        this.calculatorOperations = calculatorOperations;
        this.input = input;
        this.listHistory = listHistory;
    }

    public void showMenu(){
        int selection = 999;

        while (selection != 0) {
            operationsTracking.facadeMainMenu();
            selection = input.nextInt();
            switch (selection) {
                case 0: {
                    operationsTracking.facadeExitMessage();
                    System.exit(0);
                    break;
                }
                case 1: {
                    calculatorOperations.doCalcInput();
                    break;
                }
                case 2: {
                    operationsTracking.setSuccessLog(listHistory.list().toString());
                    break;
                }
                default: {
                    operationsTracking.setErrorLog("Invalid option, please try again!");
                }
            }
        }
    }


}


