package org.example.service;

import org.example.util.Animal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnimalService {


    public static Set<String> getAnimalOwners(List<Animal> listOfPatients){
        Set<String> listOfOwners = listOfPatients.stream()
                .map(Animal::getOwner)
                .collect(Collectors.toSet());
        return listOfOwners;
    }

    public static boolean checkProvidedBreed(List<Animal> listOfPatients,String breed){
        Set<String> listOfBreeds = listOfPatients.stream()
                .map(Animal::getBreed)
                .collect(Collectors.toSet());
        if(listOfBreeds.contains(breed))return true;
        else return false;
    }
    public static boolean checkProvidedOwner(List<Animal> listOfPatients,String owner){
        Set<String> listOfBreeds = listOfPatients.stream()
                .map(Animal::getOwner)
                .collect(Collectors.toSet());
        if(listOfBreeds.contains(owner))return true;
        else return false;
    }
    public static boolean checkProvidedDate(List<Animal> listOfPatients,String date){
        Set<LocalDate> listOfDates = listOfPatients.stream()
                .map(Animal::getDate)
                .map(LocalDateTime::toLocalDate)
                .collect(Collectors.toSet());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parseDate = LocalDate.parse(date,formatter);
        if(listOfDates.contains(parseDate))return true;
        else return false;
    }

    public static List<Animal> getAnimalByBreed(List<Animal> listOfPatients,String breed){
        List<Animal> listOfAnimal = listOfPatients.stream()
                .filter(animal->breed.equals(animal.getBreed()))
                .collect(Collectors.toList());
        return listOfAnimal;
    }

    public static List<Animal> getAnimalByOwner(List<Animal> listOfPatients,String owner){
        List<Animal> listOfAnimal = listOfPatients.stream()
                .filter(animal->owner.equals(animal.getOwner()))
                .collect(Collectors.toList());
        return listOfAnimal;
    }
    public static List<Animal> getAnimalByDate(List<Animal> listOfPatients,String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parseDate = LocalDate.parse(date,formatter);
        List<Animal> listOfAnimal = listOfPatients.stream()
                .filter(animal->parseDate.equals(animal.getDate().toLocalDate()))
                .collect(Collectors.toList());
        return listOfAnimal;
    }
}
