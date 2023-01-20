package org.example.controller;

import org.example.service.MyTerminalReader;

import java.util.Locale;

public class OptionController {

    public static boolean checkReviewOrAddProvided(String reviewOrAdd){
        reviewOrAdd=reviewOrAdd.strip();
        if(reviewOrAdd.isEmpty() || reviewOrAdd==null || !reviewOrAdd.toLowerCase().equals("review") || !reviewOrAdd.toLowerCase().equals("add")){
            System.out.println("There's no such option");
            return false;
        }
        return true;
    }
    public static boolean checkcontinueTheProgramAnswer(String reviewOrAdd){
        reviewOrAdd=reviewOrAdd.strip();
        if(reviewOrAdd.isEmpty() || reviewOrAdd==null || !reviewOrAdd.toLowerCase().equals("n")){
            System.out.println("Program returns to startup phase");
            return false;
        }
        return true;
    }

    public static void review(){

    }

    public static void add(){

    }
}
