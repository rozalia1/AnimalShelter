package com.company.models.cage;

public class SmallCage extends BaseCage {
    private final static int CAPACITY = 10;
    public SmallCage(String name) {
        super(name, CAPACITY);
    }
}
