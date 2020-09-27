package com.company.core;

import com.company.enums.TreatmentType;
import com.company.models.animals.Animal;
import com.company.models.animals.Dog;
import com.company.models.cage.DogCage;
import com.company.models.cage.ICage;
import com.company.repositories.DecorationRepo;

import java.util.ArrayList;
import java.util.Collection;

public class DogShelter implements Shelter {
    DecorationRepo decorations;
    Collection<DogCage> cages;
    Collection<Dog> dogs;
    Collection<Dog> sickDogs;

    public DogShelter() {
        this.decorations = new DecorationRepo();
        this.cages = new ArrayList<>();
        this.dogs = new ArrayList<>();
        this.sickDogs = new ArrayList<>();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (DogCage cage : cages) {
            sb.append(cage.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String setSickAnimal(Animal a, TreatmentType treatType) {
        return null;
    }

    @Override
    public String treatAnimal(Animal a, TreatmentType treatType) {
        return null;
    }

    @Override
    public boolean isCured() {
        return false;
    }
}
