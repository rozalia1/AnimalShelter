package com.company.models.cage;

import com.company.enums.cage.CageType;
import com.company.models.decoration.Decoration;

import java.util.Collection;

import static com.company.messages.ExceptionMessages.INVALID_CAGE_TYPE;
import static com.company.messages.ExceptionMessages.NO_DECORATION_FOUND;

public class CageController {
    private final static int BIG_CAGE_CAPACITY = 30;
    private final static int SMALL_CAGE_CAPACITY = 10;

    public DogCage createCage(String cageName, String cageType) {
        DogCage cage;

        switch(CageType.valueOf(cageType.toUpperCase())) {
            case SMALL:
                cage = new DogCage(cageName, SMALL_CAGE_CAPACITY, CageType.SMALL);
                break;
            case BIG:
                cage = new DogCage(cageName, BIG_CAGE_CAPACITY, CageType.BIG);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAGE_TYPE);
        }

        return cage;
    }

    public DogCage insertDecorationToCage(String cageName, Collection<DogCage> cages, Decoration dec) {
        if (dec == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, dec.getClass().getSimpleName()));
        }

        DogCage cage = cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);
        cage.addDecoration();

        return null;
    }
}
