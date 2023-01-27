package org.example.controller;

import org.example.cache.AnimalStore;
import org.example.service.AnimalService;
import org.example.service.MyPrinter;
import org.example.service.MyTerminalReader;

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
        AnimalStore animalStore = new AnimalStore();
        MyPrinter.getOnTerminal(animalStore.getAnimalStore());
        System.out.println("Would you like to filter the results? y/n");
        String filterAnswer = MyTerminalReader.readLine().toLowerCase().strip();
        if(filterAnswer.equals("y")){
            System.out.println("Enter what the results will be filtered by. owner/breed/date");
            String filterBy = MyTerminalReader.readLine().toLowerCase().strip();
            if(OptionController.checkFiltrOption(filterBy)) {
                switch (filterBy) {
                    case "owner" -> {
                        MyPrinter.getOnTerminal(AnimalService.getAnimalByOwner(animalStore.getAnimalStore(), filterBy));
                    }
                    case "breed" -> {
                        MyPrinter.getOnTerminal(AnimalService.getAnimalByBreed(animalStore.getAnimalStore(), filterBy));
                    }
                    case "date" -> {
                        MyPrinter.getOnTerminal(AnimalService.getAnimalByDate(animalStore.getAnimalStore(), filterBy));
                    }
                }
            }
        }
    }

    public static boolean checkFiltrOption(String option){
        if(option.equals("owner") || option.equals("breed") || option.equals("date")) return true;
        System.out.println("There is no such option.");
        return false;
    }

    public static void add(){

    }
}
