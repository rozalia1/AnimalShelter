package com.company.models.cage;

public class SmallICage extends BaseICage {
    private final static int CAPACITY = 10;
    public SmallICage(String name) {
        super(name, CAPACITY);
    }
}
