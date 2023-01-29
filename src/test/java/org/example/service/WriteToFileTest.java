package org.example.service;

import org.example.util.Animal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteToFileTest {

    @Test
    void saveToFile() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","test","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        //then
        assertDoesNotThrow(()->{
            WriteToFile.saveToFile(testAnimalList);
        });
    }
}