package org.example.controller;

public class OptionController {

    public static boolean checkReviewOrAddProvided(String reviewOrAdd){
        if(reviewOrAdd != null) {
            reviewOrAdd = reviewOrAdd.strip();
            reviewOrAdd = reviewOrAdd.toLowerCase();
            if (!reviewOrAdd.equals("review") && !reviewOrAdd.equals("add")) {
                System.out.println("There's no such option");
                return false;
            }
            return true;
        }else return false;
    }
    public static boolean checkContinueTheProgramAnswer(String optionExit){
        if(optionExit != null) {
            optionExit = optionExit.strip();
            optionExit = optionExit.toLowerCase();
            if (!optionExit.equals("n")) {
                System.out.println("Program returns to initial phase");
                return false;
            }
            return true;
        }else return false;
    }

    public static void review(){
        
    }

    public static void add(){

    }
}
