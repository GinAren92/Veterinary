package org.example.util;

import java.time.LocalDateTime;

public class Animal {
    private final String name;
    private final String owner;
    private final String breed;
    private final int age;
    private final String issue;
    private final LocalDateTime date;

    public Animal(){
        name=null;
        owner=null;
        breed=null;
        age=0;
        issue=null;
        date=null;
    }

    public Animal(String name, String owner,String breed,int age,String issue){
        this.date = LocalDateTime.now();
        this.name = name;
        this.owner = owner;
        this.age = age;
        this.breed = breed;
        this.issue = issue;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getIssue() {
        return issue;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
