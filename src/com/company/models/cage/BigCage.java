package com.company.models.cage;

public class BigCage extends BaseCage {
    private final static int CAPACITY = 30;

    public BigCage(String name) {
        super(name, CAPACITY);
    }
}
