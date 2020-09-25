package com.company.models.decoration;

public class Toy extends BaseDecoration{

    private static final int COMFORT = 2;
    private static final double PRICE = 10;

    public Toy() {
        super(COMFORT, PRICE);
    }
}
