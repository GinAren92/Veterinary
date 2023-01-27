package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.util.Animal;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ReadFromFile {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        OBJECT_MAPPER.registerModule(javaTimeModule);
        OBJECT_MAPPER.setDateFormat(simpleDateFormat);
    }

    public static List<Animal> readFromFile(){
        try {
            Set<String> listOfOwners = OBJECT_MAPPER.readValue(new File("owners.json"), new TypeReference<Set<String>>(){});
            List<Animal> listNotSortedPatients = new ArrayList<>();
            if(listOfOwners.size()>0){
                listOfOwners.forEach((owner)->{
                    File filePath = new File("Owners/"+owner+"/animals.json");
                    if(filePath.exists()){
                        try {
                            List<Animal> currentOwnerAnimals = OBJECT_MAPPER.readValue(filePath, new TypeReference<List<Animal>>() {});
                            listNotSortedPatients.addAll(currentOwnerAnimals);
                        } catch (IOException e) {
                            throw new Error(e);
                        }
                    }
                });
            }
            listNotSortedPatients.sort(Comparator.comparing(animal -> animal.getDate()));
            return listNotSortedPatients;

        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
