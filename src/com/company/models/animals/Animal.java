package com.company.models.animals;

import com.company.enums.TreatmentPhase;
import com.company.enums.TreatmentType;

public abstract class Animal {
    private String name;
    private int ateSize;
    private double price;
    private TreatmentType treatType;
    private TreatmentPhase treatPhase;

    protected Animal(String name, double price) {
        this.name = name;
        this.price = price;
        ateSize = 0;
        treatType = TreatmentType.NONE;
        treatPhase = TreatmentPhase.NONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAteSize() {
        return ateSize;
    }

    public void incrAteSize(int ateSize) {
        this.ateSize += ateSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TreatmentType getTreatType() {
        return treatType;
    }

    public void setTreatType(TreatmentType treatType) {
        this.treatType = treatType;
    }

    public TreatmentPhase getTreatPhase() {
        return treatPhase;
    }

    public void setTreatPhase(TreatmentPhase treatPhase) {
        this.treatPhase = treatPhase;
    }

    public abstract void eat(int sizeToEat);

    public void sleep() {
        System.out.println("ZzzZzz...");
    }
}
