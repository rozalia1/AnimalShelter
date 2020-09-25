package com.company.models.cage;

import com.company.models.decoration.Decoration;
import com.company.models.dogs.Dogs;

import java.util.Collection;

public interface Cage {
    int calculateComfort();

    String getName();

    void addDog(Dogs dog);

    void removeDog(Dogs dog);

    void addDecoration(Decoration decoration);

    void feed();

    String getInfo();

    Collection<Dogs> getDog();

    Collection<Decoration> getDecorations();
}
