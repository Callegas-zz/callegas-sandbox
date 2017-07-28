package com.callegasdev.controller;

import com.callegasdev.calculator.*;
import com.callegasdev.database.DaoHistory;
import com.callegasdev.database.ListHistory;
import com.callegasdev.database.SaveHistory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.callegasdev.profile.History;
import com.callegasdev.view.ColorFactory;
import com.callegasdev.view.MainMenu;
import com.callegasdev.view.OperationsTracking;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.callegasdev.calculator, com.callegasdev.view")
public class AppConfig {

    @Bean
    public Calculator calculator() {
        Map<String, Operation> operationList = new HashMap<>( );
        operationList.put( "+", new Sum(new OperationsTracking()) );
        operationList.put( "-", new Sub(new OperationsTracking()) );
        operationList.put( "/", new Division(new OperationsTracking()) );
        operationList.put( "*", new Multiply(new OperationsTracking()) );
        operationList.put( "^", new Pow(new OperationsTracking()) );

        Calculator calculator = new Calculator(operationList);
        return calculator;
    }

    @Bean
    public MainMenu mainMenu() {
        MainMenu mainMenu = new MainMenu(new OperationsTracking(),
                            new CalculatorOperations( new ColorFactory(),
                                    new SaveHistory(
                                            new DaoHistory( new OperationsTracking()), new History())
                            ),
                            new Scanner(System.in).useLocale( Locale.US ), new ListHistory()
        );
        return mainMenu;
    }


}

