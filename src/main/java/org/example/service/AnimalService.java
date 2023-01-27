package org.example.service;

import org.example.util.Animal;

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
        List<Animal> listOfAnimal = listOfPatients.stream()
                .filter(animal->date.equals(animal.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .collect(Collectors.toList());
        return listOfAnimal;
    }
}
