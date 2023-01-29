package org.example.controller;

import org.example.cache.AnimalStore;
import org.example.service.*;
import org.example.util.Animal;

public class OptionController {

    public static void review(AnimalStore animalStore){
        try {
            MyPrinter.getOnTerminal(animalStore.getAnimalStore());
            System.out.println("Would you like to filter the results? y/n");
            String filterAnswer = MyTerminalReader.readLine().toLowerCase().strip();
            OptionService.filterService(filterAnswer,animalStore);
        }catch(Exception e){
            throw new Error(e);
        }
    }
    public static void add(AnimalStore animalStore){
        try {
            String animalName = AnimalDataProvider.provideName();
            String ownerName = AnimalDataProvider.provideOwnerName();
            String animalBreed = AnimalDataProvider.provideBreed();
            int animalAge = AnimalDataProvider.provideAge();
            String animalIssue = AnimalDataProvider.provideIssue();
            Animal newAnimal = new Animal(animalName, ownerName, animalBreed, animalAge, animalIssue);
            animalStore.addAnimal(newAnimal);
        }catch (Exception e){
            throw new Error(e);
        }
    }


}
