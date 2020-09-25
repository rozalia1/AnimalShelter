package com.company.models.cage;

import com.company.models.decoration.Decoration;
import com.company.models.dogs.Dogs;

import java.util.ArrayList;
import java.util.Collection;
import static com.company.messages.ExceptionMessages.*;
import static com.company.messages.ConstantMessages.*;

public abstract class BaseCage implements Cage {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Dogs> dogs;

    public BaseCage(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.dogs = new ArrayList<>();

    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(CAGE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int sum = 0;
        for (Decoration decoration : decorations) {
            sum += decoration.getComfort();
        }
        return sum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addDog(Dogs dog) {
        if(this.dogs.size() == this.capacity){
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        this.dogs.add(dog);
    }

    @Override
    public void removeDog(Dogs dog) {
        this.dogs.remove(dog);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Dogs dog1: dogs) {
            dog1.eat();

        }
    }

    @Override
    public String getInfo() {
       return String.format("%s %s:%n Dog: %s%n Decorations: %d%n Comfort: %d",
               this.getName(), this.getClass().getSimpleName(), this.dogs.isEmpty() ? "none": printDogs(), this.decorations.size(), this.calculateComfort());
    }

    private String printDogs() {
        StringBuilder sb = new StringBuilder();

        for (Dogs dog1 : dogs) {
            sb.append(dog1.getName())
                    .append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public Collection<Dogs> getDog() {
        return dogs;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
