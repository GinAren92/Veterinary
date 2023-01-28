package org.example.service;

import org.example.util.Animal;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyPrinter {

    public static void getOnTerminal(List<Animal> listProvided){
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            listProvided.forEach((animal)->{
                System.out.println("Name: "+animal.getName());
                System.out.println("Owner: "+animal.getOwner());
                System.out.println("Breed: "+animal.getBreed());
                System.out.println("Age: "+animal.getAge());
                System.out.println("Issue: "+animal.getIssue());
                System.out.println("Date: "+animal.getDate().format(format));
                System.out.println("_________________________________________________-");
            });
        }catch(Exception e){
            throw new Error(e);
        }
    }
}
