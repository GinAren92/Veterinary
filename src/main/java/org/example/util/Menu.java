package org.example.util;

import org.example.cache.AnimalStore;
import org.example.controller.OptionController;
import org.example.service.MyTerminalReader;
import org.example.service.OptionService;

public class Menu {

    public void getStart(){
        AnimalStore animalStore = new AnimalStore();
        boolean continueLoop = true;
        while(continueLoop){
            System.out.println("Would you like to review the list of patients or add a new one? review/add");
            String reviewOrAdd = MyTerminalReader.readLine();
            if(OptionService.checkReviewOrAddProvided(reviewOrAdd)){
                switch(reviewOrAdd){
                    case "review" -> {
                        OptionController.review(animalStore);
                    }
                    case "add" -> {
                        OptionController.add(animalStore);
                    }
                }
            }
            System.out.println("Do you want to continue the program? y/n");
            String continueTheProgramAnswer = MyTerminalReader.readLine();
            if(OptionService.checkContinueTheProgramAnswer(continueTheProgramAnswer)) continueLoop = false;
        }
        animalStore.saveToFile();
        try{
            MyTerminalReader.closeReader();
        }catch (Exception e){
            throw new Error(e);
        }
    }
}
