package com.company.repositories;

import com.company.models.decoration.Bed;
import com.company.models.decoration.Decoration;
import com.company.models.decoration.Toy;

import java.util.ArrayList;
import java.util.Collection;

import static com.company.messages.ExceptionMessages.INVALID_CAGE_TYPE;
import static com.company.messages.ExceptionMessages.INVALID_DECORATION_TYPE;


public class DecorationRepo implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepo() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void addDecorationByType(String decType) {
        Decoration decoration;
        switch(decType.toLowerCase()) {
            case "bed":
                decoration = new Bed();
                break;
            case "toy":
                decoration = new Toy();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        boolean result = this.decorations.remove(decoration);
        return result;

    }

    @Override
    public Decoration findByType(String type) {
        Decoration result = this.decorations.stream().filter(d -> d.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
        return result;
    }
}
