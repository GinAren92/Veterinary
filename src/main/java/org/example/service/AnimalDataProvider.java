package org.example.service;

public class AnimalDataProvider {

    public static String provideName(){
        String name = null;
        System.out.println("Name of the animal: ");
        name = MyTerminalReader.readLine().strip();
        return name;
    }
    public static String provideOwnerName(){
        String ownerName = null;
        System.out.println("Name of the owner: ");
        ownerName = MyTerminalReader.readLine().strip();
        return ownerName;
    }
    public static String provideBreed(){
        String breed = "";
        System.out.println("Specify the breed: ");
        breed = MyTerminalReader.readLine().strip();
        return breed;
    }
    public static int provideAge(){
        int age = 0;
        System.out.println("How old is the animal: ");
        age = Integer.parseInt(MyTerminalReader.readLine().strip());
        return age;
    }
    public static String provideIssue(){
        String issue = null;
        System.out.println("State the reason for your visit: ");
        issue = MyTerminalReader.readLine().strip();
        return issue;
    }
}
