package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.util.Animal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WriteToFile {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        OBJECT_MAPPER.registerModule(javaTimeModule);
        OBJECT_MAPPER.setDateFormat(simpleDateFormat);
    }
    public static void saveToFile(List<Animal> listOfPatients){
        try{
            Set<String> listOfOwners = AnimalService.getAnimalOwners(listOfPatients);
            listOfOwners.forEach((owner)->{
                List<Animal> currentOwnerAnimals = listOfPatients.stream()
                        .filter(animal -> owner.equals(animal.getOwner()))
                        .collect(Collectors.toList());
                File filePath = new File("Owners/"+owner);
                filePath.mkdirs();
                filePath = new File("Owners/"+owner+"/animals.json");
                try {
                    OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(filePath,currentOwnerAnimals);
                } catch (IOException e) {
                    throw new Error(e);
                }
            });
            OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(Paths.get("owners.json").toFile(),listOfOwners);
        }catch(Exception e){
            throw new Error(e);
        }
    }

}
