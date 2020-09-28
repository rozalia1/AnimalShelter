package com.company.models.cage;

import com.company.enums.cage.CageType;
import com.company.models.animals.Animal;
import com.company.models.decoration.Decoration;

import java.util.Collection;

import static com.company.messages.ExceptionMessages.*;
import static com.company.messages.ConstantMessages.*;

public class CageController {
    private final static int BIG_CAGE_CAPACITY = 30;
    private final static int SMALL_CAGE_CAPACITY = 10;

    public DogCage createCage(String cageName, String cageType) {

        if (!CageType.checkCageType(cageType)) {
            throw new IllegalArgumentException(INVALID_CAGE_TYPE);
        }
        cageType = cageType.toUpperCase();
        int capacity = CageType.valueOf(cageType) == CageType.BIG ? BIG_CAGE_CAPACITY : SMALL_CAGE_CAPACITY;

        return new DogCage(cageName, capacity, CageType.valueOf(cageType));
    }


    public DogCage findCageByName(String cageName, Collection<DogCage> cages) {
        DogCage cage = cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);
        return cage;
    }

    public String calculateValue(String cageName, Collection<DogCage> cages) {
        DogCage cage = findCageByName(cageName, cages);
        double sum = 0.0;
        for (Decoration dec : cage.getCageDecorations()) {
            sum += dec.getPrice();
        }

        for (Animal dog1 : cage.getAnimals()) {
            sum += dog1.getPrice();
        }

        return String.format(VALUE_CAGE, cageName, sum);
    }
}
