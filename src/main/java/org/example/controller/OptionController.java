package org.example.controller;

import org.example.cache.AnimalStore;
import org.example.service.AnimalDataProvider;
import org.example.service.AnimalService;
import org.example.service.MyPrinter;
import org.example.service.MyTerminalReader;
import org.example.util.Animal;

import java.util.List;

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

    public static void review(AnimalStore animalStore){
        MyPrinter.getOnTerminal(animalStore.getAnimalStore());
        System.out.println("Would you like to filter the results? y/n");
        String filterAnswer = MyTerminalReader.readLine().toLowerCase().strip();
        if(filterAnswer.equals("y")){
            System.out.println("Enter what the results will be filtered by. owner/breed/date");
            String filterBy = MyTerminalReader.readLine().toLowerCase().strip();
            if(OptionController.checkFiltrOption(filterBy)) {
                switch (filterBy) {
                    case "owner" -> {
                        do{
                            System.out.println("Enter the name of the owner: ");
                            String ownerName = MyTerminalReader.readLine();
                            if(AnimalService.checkProvidedOwner(animalStore.getAnimalStore(),ownerName)) {
                                List<Animal> tmpListByOwner =AnimalService.getAnimalByOwner(animalStore.getAnimalStore(), ownerName);
                                MyPrinter.getOnTerminal(tmpListByOwner);
                                break;
                            }else System.out.println("The specified parameter does not exist in the database.");
                        }while(true);
                    }
                    case "breed" -> {
                        do{
                            System.out.println("Enter the name of the breed");
                            String breedName = MyTerminalReader.readLine();
                            if(AnimalService.checkProvidedBreed(animalStore.getAnimalStore(),breedName)) {
                                List<Animal> tmpListByBreed = AnimalService.getAnimalByBreed(animalStore.getAnimalStore(), breedName);
                                MyPrinter.getOnTerminal(tmpListByBreed);
                                break;
                            }else System.out.println("The specified parameter does not exist in the database.");
                        }while(true);
                    }
                    case "date" -> {
                        do{
                            System.out.println("Podaj datę w formacie dd-MM-yyyy:");
                            String provideDate = MyTerminalReader.readLine();
                            if(AnimalService.checkProvidedDate(animalStore.getAnimalStore(),provideDate)) {
                                List<Animal> tmpListByDate = AnimalService.getAnimalByDate(animalStore.getAnimalStore(), provideDate);
                                MyPrinter.getOnTerminal(tmpListByDate);
                                break;
                            }else System.out.println("The specified parameter does not exist in the database.");
                        }while(true);
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

    public static void add(AnimalStore animalStore){
        String animalName = AnimalDataProvider.provideName();
        String ownerName = AnimalDataProvider.provideOwnerName();
        String animalBreed = AnimalDataProvider.provideBreed();
        int animalAge = AnimalDataProvider.provideAge();
        String animalIssue = AnimalDataProvider.provideIssue();
        Animal newAnimal = new Animal(animalName,ownerName,animalBreed,animalAge,animalIssue);
        animalStore.addAnimal(newAnimal);
    }
}
