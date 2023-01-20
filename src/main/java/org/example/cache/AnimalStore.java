package org.example.cache;

import org.example.util.Animal;

import java.util.List;

public class AnimalStore {

    private final List<Animal> animalStore;

    public AnimalStore() {
        animalStore = null;
    }

    public List<Animal> getAnimalStore() {
        return animalStore;
    }
}
