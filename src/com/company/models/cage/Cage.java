package com.company.models.cage;

import com.company.models.animals.Animal;
import com.company.models.decoration.Decoration;
import com.company.repositories.DecorationRepo;

import java.util.ArrayList;
import java.util.Collection;

import static com.company.messages.ConstantMessages.*;

public abstract class Cage {
    String name;
    int capacity;
    Collection<Decoration> cageDecorations;
    Collection<Animal> animals;

    protected Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.cageDecorations = new ArrayList<>();
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

    public void incrCapacity(int capacity) {
        this.capacity += capacity;
    }

    public Collection<Decoration> getCageDecorations() {
        return cageDecorations;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public abstract void addAnimal(Animal animal);
    public abstract String addDecoration(String type, DecorationRepo decRepo);

    public String getInfo() {
        return String.format("%s %s:%n Dog: %s%n Decorations: %d%n Comfort: %d",
                this.getName(),
                this.getClass().getSimpleName(),
                this.animals.isEmpty() ? "none": printAnimals(), this.cageDecorations.size(), this.calculateComfort());
    }


    public int calculateComfort() {
        int sum = 0;
        for (Decoration decoration : cageDecorations) {
            sum += decoration.getComfort();
        }
        return sum;
    }

    public String feedAnimals(int foodSize) {
        animals.forEach(animal -> animal.eat(foodSize));
        int count = this.animals.size();
        return String.format(DOGS_FED, count);
    }

    public String printAnimals() {
        StringBuilder sb = new StringBuilder();

        for (Animal animal : animals) {
            sb.append(animal.getName()).append(" ");
        }
        return sb.toString().trim();
    }
}
