package com.callegasdev.controller;

import com.callegasdev.database.SaveHistory;
import org.springframework.stereotype.Component;
import com.callegasdev.view.ColorFactory;
import com.callegasdev.calculator.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Locale;
import java.util.Scanner;

@Component
public class CalculatorOperations {

    private ColorFactory colorFactory;
    private SaveHistory saveHistory;

    public CalculatorOperations(ColorFactory colorFactory, SaveHistory saveHistory) {
        this.colorFactory = colorFactory;
        this.saveHistory = saveHistory;
    }

    public boolean doCalc(Double x, Double y, String operation){
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext( AppConfig.class );
            Calculator calculator = (Calculator) applicationContext.getBean( "calculator" );
            calculator.executeCalculator( x, y, operation );
            String result = "Operation " + x + " " + operation + " " + y + " = " + calculator.executeCalculator( x, y, operation );
            saveHistory.save( result );
            ((AnnotationConfigApplicationContext) applicationContext).close();
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public void doCalcInput(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US );
        System.out.print(colorFactory.ANSI_WHITE_BACKGROUND + colorFactory.ANSI_BLACK);
        System.out.print("Enter the first value:     ");
        Double x = input.nextDouble();

        System.out.print("Enter the operation:       ");
        String operation = input.next();

        System.out.print("Enter the second value:    ");
        Double y = input.nextDouble();

        System.out.print(colorFactory.ANSI_RESET);

        doCalc(x, y, operation);
    }


}
