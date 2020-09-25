package com.company.models.dogs;

public class SmallDogs extends BaseDog {
    private static final int INITIAL_SIZE = 5;
    private static final int INCREASE_SIZE = 3;

    public SmallDogs(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        int oldSize = super.getSize();
        super.setSize(oldSize += INCREASE_SIZE);
    }
}
