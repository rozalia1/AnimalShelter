package com.company.models.cage;

import com.company.models.animals.Animal;
import com.company.models.decoration.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Cage {
    String name;
    int capacity;
    Collection<Decoration> decorations;
    Collection<Animal> animals;

    protected Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Collection<Decoration> getDecorations() {
        return decorations;
    }

    public void setDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public abstract void addAnimal(Animal animal);
    public abstract void addDecoration(Decoration decoration);

    public void feed(int foodSize) {
        animals.forEach(animal -> animal.eat(foodSize));
    }

    public String printAnimals() {
        StringBuilder sb = new StringBuilder();

        for (Animal animal : animals) {
            sb.append(animal.getName()).append(" ");
        }
        return sb.toString().trim();
    }
}
