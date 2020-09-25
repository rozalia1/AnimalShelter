package com.company.models.dogs;

import static com.company.messages.ExceptionMessages.*;

public abstract class BaseDog implements Dogs{

    private String name;
    private String species;
    private int size;
    private double price;

    public BaseDog(String name, String species , double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
    }

    public void setSpecies(String species) {
        if(species == null || species.trim().isEmpty()){
            throw new NullPointerException(SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    private void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(DOG_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }
    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(DOG_NAME_NULL_OR_EMPTY);
        }
        this.name=name;
    }

    @Override
    public abstract void eat();  //The method is abstract because every dog will have its own eating method

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
