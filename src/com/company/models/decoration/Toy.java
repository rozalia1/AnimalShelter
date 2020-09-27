package com.company.models.decoration;

public class Toy implements Decoration {
    private int comfort;
    private double price;

    public Toy() {
        this.comfort = 2;
        this.price = 10;
    }

    @Override
    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    @Override
    public int getComfort() {
        return this.comfort;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
