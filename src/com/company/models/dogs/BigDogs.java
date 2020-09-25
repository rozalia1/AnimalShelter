package com.company.models.dogs;

public class BigDogs extends BaseDog{
    private static final int INITIAL_SIZE = 10;
    private static final int INCREASE_SIZE = 5;

    public BigDogs(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        int oldSize = super.getSize();
        super.setSize(oldSize + INCREASE_SIZE);


    }

}
