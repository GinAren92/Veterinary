package org.example.cache;

import org.example.service.ReadFromFile;
import org.example.service.WriteToFile;
import org.example.util.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalStore {

    private static List<Animal> animalStore;

    public AnimalStore() {
        animalStore = ReadFromFile.readFromFile();
    }

    public List<Animal> getAnimalStore() {
        return animalStore;
    }
    public void saveToFile(){
        WriteToFile.saveToFile(this.getAnimalStore());
    }
}
