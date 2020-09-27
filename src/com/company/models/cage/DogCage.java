package com.company.models.cage;

import com.company.enums.cage.CageType;
import com.company.models.animals.Animal;
import com.company.models.decoration.Decoration;

import java.util.Collection;

import static com.company.messages.ConstantMessages.NOT_ENOUGH_CAPACITY;

public class DogCage extends Cage {
    // da se pomisli tezi konstanti kak moje da se napravqt po-optimalno i dali da ne sa nqkyde drugade, napr. v klasa
    // kudeto shte se vikat tezi metodi
    private final static int BIG_CAGE_CAPACITY = 30;
    private final static int SMALL_CAGE_CAPACITY = 10;

    CageType type;

    public DogCage(String cageName, int capacity, CageType type) {
        super(cageName, capacity);
        this.type = type;
    }

    public CageType getType() {
        return type;
    }

    public void setType(CageType type) {
        this.type = type;
    }

    @Override
    public void addAnimal(Animal dog) {
        Collection<Animal> dogs = getAnimals();
        if(dogs.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }

        setAnimal(dog);
    }

    @Override
    public void addDecoration(Decoration dec) {
        setDecoration(dec);
    }
}