package com.company.core;

import com.company.enums.TreatmentType;
import com.company.models.animals.Animal;
import com.company.models.animals.Dog;
import com.company.models.cage.DogCage;
import com.company.repositories.DecorationRepo;

import java.util.ArrayList;
import java.util.Collection;

public class DogShelter implements Shelter {
    DecorationRepo decorationRepo;
    Collection<DogCage> cages;
    Collection<Dog> dogs;
    Collection<Dog> sickDogs;

    public DogShelter() {
        this.decorationRepo = new DecorationRepo();
        this.cages = new ArrayList<>();
        this.dogs = new ArrayList<>();
        this.sickDogs = new ArrayList<>();
    }

    public DecorationRepo getDecorations() {
        return decorationRepo;
    }

    public Collection<DogCage> getCages() {
        return cages;
    }

    public void addCage(DogCage cage) {
        this.cages.add(cage);
    }

    public Collection<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        this.dogs.add(dog);
    }

    public Collection<Dog> getSickDogs() {
        return sickDogs;
    }

    public void addSickDog(Dog sickDog) {
        this.sickDogs.add(sickDog);
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
