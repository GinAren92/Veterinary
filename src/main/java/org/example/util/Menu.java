package org.example.util;

import org.example.controller.OptionController;
import org.example.service.MyTerminalReader;

public class Menu {

    public void getStart(){
        boolean continueLoop = true;
        while(continueLoop){
            System.out.println("Would you like to review the list of patients or add a new one? review/add");
            String reviewOrAdd = MyTerminalReader.readLine();
            if(OptionController.checkReviewOrAddProvided(reviewOrAdd)){
                switch(reviewOrAdd){
                    case "review" -> {
                        OptionController.review();
                    }
                    case "add" -> {
                        OptionController.add();
                    }
                }
            }
            System.out.println("Do you want to continue the program? y/n");
            String continueTheProgramAnswer = MyTerminalReader.readLine();
            if(OptionController.checkcontinueTheProgramAnswer(continueTheProgramAnswer)) continueLoop = false;
        }
    }
}
