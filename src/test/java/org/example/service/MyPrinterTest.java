package org.example.service;

import org.example.util.Animal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyPrinterTest {

    @Test
    void getOnTerminal() {
        //given
        List<Animal> testList = new ArrayList<>();
        Animal anima1 = new Animal("test","testOwner","testBreed",1,"test Issue");
        //when
        testList.add(anima1);
        //then
        assertDoesNotThrow(()->{
            MyPrinter.getOnTerminal(testList);
        });
    }
}