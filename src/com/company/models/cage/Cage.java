package com.company.models.cage;

import com.company.models.animals.Animal;
import com.company.models.animals.Dogs;
import com.company.models.decoration.Decoration;

import java.util.ArrayList;
import java.util.Collection;

import static com.company.messages.ConstantMessages.DOGS_FED;
import static com.company.messages.ConstantMessages.VALUE_CAGE;

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

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public abstract void addAnimal(Animal animal);
    public abstract String addDecoration(Decoration decoration);

    public String getInfo() {
        return String.format("%s %s:%n Dog: %s%n Decorations: %d%n Comfort: %d",
                this.getName(),
                this.getClass().getSimpleName(),
                this.animals.isEmpty() ? "none": printAnimals(), this.decorations.size(), this.calculateComfort());
    }

    public String calculateValue() {
        double sum = 0.0;
        for (Decoration dec : this.decorations) {
            sum += dec.getPrice();
        }

        for (Animal animal : this.animals) {
            sum += animal.getPrice();
        }

        return String.format(VALUE_CAGE, this.name, sum);
    }

    public int calculateComfort() {
        int sum = 0;
        for (Decoration decoration : decorations) {
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
