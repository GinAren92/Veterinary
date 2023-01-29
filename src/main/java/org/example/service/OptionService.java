package org.example.service;

import org.example.cache.AnimalStore;
import org.example.util.Animal;

import java.util.List;

public class OptionService {

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

    public static void filterService(String filterAnswer, AnimalStore animalStore){
        if (filterAnswer.equals("y")) {
            System.out.println("Enter what the results will be filtered by. owner/breed/date");
            String filterBy = MyTerminalReader.readLine().toLowerCase().strip();
            if (OptionService.checkFilterOption(filterBy)) {
                switch (filterBy) {
                    case "owner" -> {
                        filterByOwner(animalStore);
                    }
                    case "breed" -> {
                        filterByBreed(animalStore);
                    }
                    case "date" -> {
                        filterByDate(animalStore);
                    }
                }
            }
        }
    }

    private static void filterByOwner(AnimalStore animalStore){
        do {
            System.out.println("Enter the name of the owner: ");
            String ownerName = MyTerminalReader.readLine();
            if (AnimalService.checkProvidedOwner(animalStore.getAnimalStore(), ownerName)) {
                List<Animal> tmpListByOwner = AnimalService.getAnimalByOwner(animalStore.getAnimalStore(), ownerName);
                MyPrinter.getOnTerminal(tmpListByOwner);
                break;
            } else System.out.println("The specified parameter does not exist in the database.");
        } while (true);
    }
    private static void filterByBreed(AnimalStore animalStore){
        do {
            System.out.println("Enter the name of the breed");
            String breedName = MyTerminalReader.readLine();
            if (AnimalService.checkProvidedBreed(animalStore.getAnimalStore(), breedName)) {
                List<Animal> tmpListByBreed = AnimalService.getAnimalByBreed(animalStore.getAnimalStore(), breedName);
                MyPrinter.getOnTerminal(tmpListByBreed);
                break;
            } else System.out.println("The specified parameter does not exist in the database.");
        } while (true);
    }
    private static void filterByDate(AnimalStore animalStore){
        do {
            System.out.println("Enter the date in the format dd-MM-yyyy:");
            String provideDate = MyTerminalReader.readLine();
            if (AnimalService.checkProvidedDate(animalStore.getAnimalStore(), provideDate)) {
                List<Animal> tmpListByDate = AnimalService.getAnimalByDate(animalStore.getAnimalStore(), provideDate);
                MyPrinter.getOnTerminal(tmpListByDate);
                break;
            } else System.out.println("The specified parameter does not exist in the database.");
        } while (true);
    }

    public static boolean checkFilterOption(String option){
        option = option.toLowerCase().strip();
        if(option.equals("owner") || option.equals("breed") || option.equals("date")) return true;
        System.out.println("There is no such option.");
        return false;
    }
}
