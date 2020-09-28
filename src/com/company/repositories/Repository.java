package com.company.repositories;

import com.company.models.decoration.Decoration;

public interface Repository {

    void addDecorationByType(String decType);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);

    boolean isExist(String type);
}

