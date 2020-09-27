package com.company.models.animals;

import com.company.enums.dog.DogType;

public class Dog extends Animal {
    private static final int SMALL_INITIAL_EAT_SIZE = 10;
    private static final int SMALL_INCREASE_SIZE = 5;
    private static final int BIG_INITIAL_EAT_SIZE = 5;
    private static final int BIG_INCREASE_SIZE = 3;
    DogType type;
    String species;

    public Dog(String name, int order, double price, DogType type, String species) {
        super(name, order, price);
        this.type = type;
        this.species = species;
    }

    public DogType getType() {
        return type;
    }

    public void setType(DogType type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
