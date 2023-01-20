package org.example.util;

import java.time.LocalDateTime;

public class Animal {
    private String name;
    private String owner;
    private String breed;
    private int age;
    private String issue;
    private LocalDateTime date;

    public Animal(){

    }

    public Animal(String name, String owner,String breed,int age,String issue){
        setName(name);
        setAge(age);
        setBreed(breed);
        setIssue(issue);
        setOwner(owner);
        setDate(LocalDateTime.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
