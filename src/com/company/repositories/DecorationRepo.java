package com.company.repositories;

import com.company.models.decoration.Decoration;

import java.util.ArrayList;
import java.util.Collection;


public class DecorationRepo implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepo() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
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
