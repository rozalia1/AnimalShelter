package com.company.commands;


import com.company.core.DogShelter;

public class DogCommands implements Command {
    private DogShelter dogShelter;
    private String cageName;
    private String dogType;
    private String dogName;
    private String dogSpecies;
    private double price;

    public DogCommands(DogShelter dogShelter, String[] data){
        this.dogShelter = dogShelter;
        cageName = data[0];
        dogType = data[1];
        dogName = data[2];
        dogSpecies = data[3];
        price = Double.parseDouble(data[4]);
    }

    @Override
    public String execute() {
        return this.dogShelter.addDog(cageName, dogType, dogName, dogSpecies, price);
    }
}
