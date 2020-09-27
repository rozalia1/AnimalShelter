package com.company.models.cage;

import com.company.enums.cage.CageType;
import com.company.models.animals.Animal;
import com.company.models.decoration.Decoration;
import com.company.repositories.DecorationRepo;

import java.util.Collection;

import static com.company.messages.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static com.company.messages.ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_CAGE;
import static com.company.messages.ExceptionMessages.INVALID_CAGE_TYPE;
import static com.company.messages.ExceptionMessages.NO_DECORATION_FOUND;

public class DogCage extends Cage {
    CageType type;

    public DogCage(){
        super("", 0);
    }

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

    public void addAnimal(Animal dog) {
        Collection<Animal> dogs = getAnimals();
        if(dogs.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }

        animals.add(dog);
    }

    public String addDecoration(String type, DecorationRepo decRepo) {
        Decoration dec = decRepo.findByType(type);

        cageDecorations.add(dec);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_CAGE, this.type, getName());
    }


}
