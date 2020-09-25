package com.company.repositories;

import com.company.models.decoration.Decoration;

public interface Repository {

        void add(Decoration decoration);

        boolean remove(Decoration decoration);

        Decoration findByType(String type);
    }

