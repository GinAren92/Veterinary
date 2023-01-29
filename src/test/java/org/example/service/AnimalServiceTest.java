package org.example.service;

import org.example.util.Animal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnimalServiceTest {

    @Test
    void getAnimalOwnersEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        Set<String> testResponseSet = new HashSet<>();
        final Set<String> testResponseShouldBe = new HashSet<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseSet=AnimalService.getAnimalOwners(testAnimalList);
        testResponseShouldBe.add(animal1.getOwner());
        testResponseShouldBe.add(animal2.getOwner());
        testResponseShouldBe.add(animal3.getOwner());
        testResponseShouldBe.add(animal4.getOwner());
        //then
        assertEquals(testResponseShouldBe,testResponseSet);
    }
    @Test
    void getAnimalOwnersNotEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        Set<String> testResponseSet = new HashSet<>();
        final Set<String> testResponseShouldBe = new HashSet<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testResponseSet=AnimalService.getAnimalOwners(testAnimalList);
        testResponseShouldBe.add(animal1.getOwner());
        testResponseShouldBe.add(animal2.getOwner());
        testResponseShouldBe.add(animal3.getOwner());
        testResponseShouldBe.add(animal4.getOwner());
        //then
        assertNotEquals(testResponseShouldBe,testResponseSet);
    }
    @Test
    void checkProvidedBreedTrue() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final String testBreed = "testBreed";
        boolean result;

        final Animal animal1 = new Animal("test","testOwner1","testBreed1",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed2",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        result=AnimalService.checkProvidedBreed(testAnimalList,testBreed);
        //then
        assertTrue(result);
    }
    @Test
    void checkProvidedBreedFalse() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final String testBreed = "testBreed";
        boolean result;

        final Animal animal1 = new Animal("test","testOwner1","testBreed1",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed1",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed2",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed 4",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        result=AnimalService.checkProvidedBreed(testAnimalList,testBreed);
        //then
        assertFalse(result);
    }

    @Test
    void checkProvidedOwnerTrue() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final String testOwner = "testOwner1";
        boolean result;

        final Animal animal1 = new Animal("test","testOwner1","testBreed1",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed2",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        result=AnimalService.checkProvidedOwner(testAnimalList,testOwner);
        //then
        assertTrue(result);
    }
    @Test
    void checkProvidedOwnerFalse() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final String testOwner = "testOwner1";
        boolean result;

        final Animal animal1 = new Animal("test","testOwner","testBreed1",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed2",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        result=AnimalService.checkProvidedOwner(testAnimalList,testOwner);
        //then
        assertFalse(result);
    }

    @Test
    void checkProvidedDateTrue() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final String testDate = "29-01-2023";
        boolean result;

        final Animal animal1 = new Animal("test","testOwner1","testBreed1",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed2",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        result=AnimalService.checkProvidedDate(testAnimalList,testDate);
        //then
        assertTrue(result);
    }
    @Test
    void checkProvidedDateFalse() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        final String testDate = "30-01-2023";
        boolean result;

        final Animal animal1 = new Animal("test","testOwner1","testBreed1",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed2",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        result=AnimalService.checkProvidedDate(testAnimalList,testDate);
        //then
        assertFalse(result);
    }

    @Test
    void getAnimalByBreedEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        List<Animal> testResponseList;
        final String searchedBreed = "test";
        final List<Animal> testResponseListShouldBe = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseList = AnimalService.getAnimalByBreed(testAnimalList,searchedBreed);
        testResponseListShouldBe.add(animal2);
        //then
        assertEquals(testResponseListShouldBe,testResponseList);
    }
    @Test
    void getAnimalByBreedNotEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        List<Animal> testResponseList;
        final String searchedBreed = "test";
        final List<Animal> testResponseListShouldBe = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","testOwner2","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseList = AnimalService.getAnimalByBreed(testAnimalList,searchedBreed);
        testResponseListShouldBe.add(animal1);
        testResponseListShouldBe.add(animal2);
        testResponseListShouldBe.add(animal3);
        testResponseListShouldBe.add(animal4);
        //then
        assertNotEquals(testResponseListShouldBe,testResponseList);
    }

    @Test
    void getAnimalByOwnerEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        List<Animal> testResponseList;
        final String searchedOwner = "test";
        final List<Animal> testResponseListShouldBe = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","test","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseList = AnimalService.getAnimalByBreed(testAnimalList, searchedOwner);
        testResponseListShouldBe.add(animal2);
        //then
        assertEquals(testResponseListShouldBe,testResponseList);
    }
    @Test
    void getAnimalByOwnerNotEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        List<Animal> testResponseList;
        final String searchedOwner = "test";
        final List<Animal> testResponseListShouldBe = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","test","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseList = AnimalService.getAnimalByBreed(testAnimalList, searchedOwner);
        testResponseListShouldBe.add(animal1);
        testResponseListShouldBe.add(animal2);
        testResponseListShouldBe.add(animal3);
        testResponseListShouldBe.add(animal4);
        //then
        assertNotEquals(testResponseListShouldBe,testResponseList);
    }

    @Test
    void getAnimalByDateEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        List<Animal> testResponseList;
        final LocalDate currentDate = LocalDate.now();
        final String searchedDate = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        final List<Animal> testResponseListShouldBe = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","test","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseList = AnimalService.getAnimalByDate(testAnimalList, searchedDate);
        testResponseListShouldBe.add(animal1);
        testResponseListShouldBe.add(animal2);
        testResponseListShouldBe.add(animal3);
        testResponseListShouldBe.add(animal4);
        //then
        assertEquals(testResponseListShouldBe,testResponseList);
    }@Test
    void getAnimalByDateNotEquals() {
        //given
        final List<Animal> testAnimalList = new ArrayList<>();
        List<Animal> testResponseList;
        final LocalDate currentDate = LocalDate.now().plusDays(1);
        final String searchedDate = currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        final List<Animal> testResponseListShouldBe = new ArrayList<>();
        final Animal animal1 = new Animal("test","testOwner1","testBreed",1,"testIssue");
        final Animal animal2 = new Animal("test","test","test",1,"testIssue");
        final Animal animal3 = new Animal("test","testOwner2","testBreed",1,"testIssue");
        final Animal animal4 = new Animal("test","testOwner3","testBreed",1,"testIssue");
        //when
        testAnimalList.add(animal1);
        testAnimalList.add(animal2);
        testAnimalList.add(animal3);
        testAnimalList.add(animal4);
        testResponseList = AnimalService.getAnimalByDate(testAnimalList, searchedDate);
        testResponseListShouldBe.add(animal1);
        testResponseListShouldBe.add(animal2);
        testResponseListShouldBe.add(animal3);
        testResponseListShouldBe.add(animal4);
        //then
        assertNotEquals(testResponseListShouldBe,testResponseList);
    }
}