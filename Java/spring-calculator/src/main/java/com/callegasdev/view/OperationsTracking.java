package com.callegasdev.view;

import org.springframework.stereotype.Component;

@Component
public class OperationsTracking {


    private ColorFactory colorFactory = new ColorFactory();
    private static String errorLog = " ";
    private static String successLog = " ";

    public void facadeLogo() {
        System.out.println(colorFactory.ANSI_BLUE + "_ _ _ ____ _    _    ____ ____ _  _ ____    ___ _  _ ____    ____ ___  ____ _ _  _ ____    ____ ____ _    ____ _  _ _    ____ ___ ____ ____ \n" +
                "| | | |___ |    |    |    |  | |\\/| |___     |  |__| |___    [__  |__] |__/ | |\\ | | __    |    |__| |    |    |  | |    |__|  |  |  | |__/ \n" +
                "|_|_| |___ |___ |___ |___ |__| |  | |___     |  |  | |___    ___] |    |  \\ | | \\| |__]    |___ |  | |___ |___ |__| |___ |  |  |  |__| |  \\ \n" +
                "                                                                                                                                            ");
        System.out.println("                                                                                        By Fellipe Callegas"+ colorFactory.ANSI_RESET);
    }

    public void facadeMainMenu(){

        facadeLogo();

        System.out.println(colorFactory.ANSI_YELLOW +"          ╔════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                                      SELECT THE CURRENT OPTION                               ");
        System.out.println("                                                                                              ");
        System.out.println("                                           1. Calc                                            ");
        System.out.println("                                           2. Historic                                        ");
        System.out.println("                                           0. Exit                                            ");
        System.out.println("          ╚════════════════════════════════════════════════════════════════════════════════════════════════╝\n" + ColorFactory.ANSI_RESET);

        if(getErrorLog() != " ") {
            System.out.println(colorFactory.ANSI_RED + getErrorLog() + colorFactory.ANSI_RESET);
            setErrorLog(" ");
        }

        if(getSuccessLog() != " ") {
            System.out.println(colorFactory.ANSI_GREEN + getSuccessLog() + colorFactory.ANSI_RESET);
            setSuccessLog(" ");
        }
    }

    public void facadeExitMessage(){
        System.out.println(colorFactory.ANSI_YELLOW + "___ _  _ ____ _  _ _  _ ____    ____ ____ ____    ____ ____ _  _ _  _ _ _  _ ____ \n" +
                " |  |__| |__| |\\ | |_/  [__     |___ |  | |__/    |    |  | |\\/| |\\/| | |\\ | | __ \n" +
                " |  |  | |  | | \\| | \\_ ___]    |    |__| |  \\    |___ |__| |  | |  | | | \\| |__] \n" +
                "                                                                                  ");

        System.out.println("visit callegasdev.wordpress.com" + colorFactory.ANSI_RESET);
    }

    public String getSuccessLog() {
        return successLog;
    }

    public void setSuccessLog(String successLog) {
        this.successLog = successLog;
    }

    public String getErrorLog() {
        return errorLog;
    }

    public void setErrorLog(String errorLog) {
        this.errorLog = errorLog;
    }

}
