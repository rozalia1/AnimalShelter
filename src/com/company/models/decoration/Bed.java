package com.company.models.decoration;

public class Bed implements Decoration {
    private int comfort;
    private double price;

    public Bed() {
        this.comfort = 5;
        this.price = 20;
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
