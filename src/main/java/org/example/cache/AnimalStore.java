package org.example.cache;

import org.example.service.WriteToFile;
import org.example.util.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalStore {

    private static List<Animal> animalStore=new ArrayList<>(Arrays.asList(new Animal("test","test","test",1,"test"),new Animal("test","test2","test",1,"test"),new Animal("test","test3","test",1,"test")));;

    public AnimalStore() {
        //animalStore = null;
    }

    public List<Animal> getAnimalStore() {
        return animalStore;
    }
    public static void testSave(){
        WriteToFile.saveToFile(animalStore);
    }
}
