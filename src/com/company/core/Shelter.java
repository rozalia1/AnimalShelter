package com.company.core;

import com.company.enums.TreatmentType;
import com.company.models.animals.Animal;
import com.company.models.decoration.Decoration;

public interface Shelter {
    String report();
    String setTreatmentType(Animal a, TreatmentType treatType);
    String treatAnimal(Animal a);
    String treatAnimals();
    Animal findAnimal (String animalName);
    Decoration findDecoration(String type);
    boolean isCured(Animal a);
    String adoptAnimal(String animalName, String personName);
}
