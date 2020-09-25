package com.company.core;


import com.company.models.cage.BigCage;
import com.company.models.cage.Cage;
import com.company.models.cage.SmallCage;
import com.company.models.decoration.Bed;
import com.company.models.decoration.Decoration;
import com.company.models.decoration.Toy;
import com.company.models.dogs.BigDogs;
import com.company.models.dogs.Dogs;
import com.company.models.dogs.SmallDogs;
import com.company.repositories.DecorationRepo;
import com.company.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static com.company.messages.ExceptionMessages.*;
import static com.company.messages.ConstantMessages.*;


public class ContollerClass implements Controller {

    private Repository decorations;
    private Collection<Cage> cages;

    public ContollerClass() {
        this.decorations = new DecorationRepo();
        this.cages = new ArrayList<>();
    }

    @Override
    public String addCage(String cageType, String cageName) {
        Cage c1;
        if ("BigCage".equals(cageType)) {
            c1 = new BigCage(cageName);
        } else if ("SmallCage".equals(cageType)) {
            c1 = new SmallCage(cageName);
        } else {
            throw new IllegalArgumentException(INVALID_CAGE_TYPE);
        }
        this.cages.add(c1);
        return String.format(SUCCESSFULLY_ADDED_CAGE_TYPE, cageType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration dec1;

        if ("Toy".equals(type)) {
            dec1 = new Toy();
        } else if ("Bed".equals(type)) {
            dec1 = new Bed();
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(dec1);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String cageName, String decorationType) {
        Decoration dec = decorations.findByType(decorationType);
        if (dec == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        Cage c1 = this.cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);
        c1.addDecoration(dec);
        this.decorations.remove(dec);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_CAGE, decorationType, cageName);
    }

    @Override
    public String addDog(String cageName, String dogType, String dogName, String dogSpecies, double price) {
        Dogs d1;
        if ("BigDogs".equals(dogType)) {
            d1 = new BigDogs(dogName, dogSpecies, price);
        } else if ("SmallDogs".equals(dogType)) {
            d1 = new SmallDogs(dogName, dogSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_DOG_TYPE);
        }

        Cage c1 = this.cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);

        if (!c1.getClass().getSimpleName().substring(0, 2).equals(dogType.substring(0, 2))) {
            return CAGE_NOT_SUITABLE;
        }

        c1.addDog(d1);

        return String.format(SUCCESSFULLY_ADDED_DOG_IN_CAGE, dogType, cageName);
    }

    @Override
    public String feedDog(String cageName) {
        Cage c1 = this.cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);
        c1.feed();
        int count = c1.getDog().size();
        return String.format(DOGS_FED, count);
    }

    @Override
    public String calculateValue(String cageName) {
        Cage c1 = this.cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);
        double sum = 0.0;
        for (Decoration dec1 : c1.getDecorations()) {
            sum += dec1.getPrice();
        }
        for (Dogs dog1 : c1.getDog()) {
            sum += dog1.getPrice();
        }

        return String.format(VALUE_CAGE, cageName, sum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Cage c1 : cages) {
            sb.append(c1.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
