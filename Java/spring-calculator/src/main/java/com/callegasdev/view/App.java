package com.callegasdev.view;

import com.callegasdev.controller.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( AppConfig.class );
        MainMenu mainMenu = (MainMenu) applicationContext.getBean( "mainMenu" );
        mainMenu.showMenu();
        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
