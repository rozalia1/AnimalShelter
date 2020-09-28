package com.company.models.animals;

import com.company.enums.dog.DogType;

import static com.company.messages.ExceptionMessages.INVALID_DOG_TYPE;

public class Dog extends Animal {
    DogType type;
    String species;

    public Dog() {
        super("", 0);
    }

    public Dog(String name, double price, DogType type, String species) {
        super(name, price);
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

    public Dog addDog(String dogType, String dogName, String dogSpecies, double price) {
        DogType type;
        switch(DogType.valueOf(dogType.toUpperCase())) {
            case SMALL:
                type = DogType.SMALL;
                break;
            case BIG:
                type = DogType.BIG;
                break;
            default:
                throw new IllegalArgumentException(INVALID_DOG_TYPE);
        }

        Dog dog = new Dog(dogName, price, type, dogSpecies);
        return dog;
    }

    @Override
    public void eat(int sizeToEat) {
        incrAteSize(sizeToEat);
    }
}
