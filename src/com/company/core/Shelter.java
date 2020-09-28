package com.company.core;

import com.company.enums.TreatmentType;
import com.company.models.animals.Animal;

public interface Shelter {
    String report();
    String setTreatmentType(String animalName, String treatType);
    String treatAnimal(Animal a);
    String treatAnimals();
    boolean isCured(Animal a);
    String adoptAnimal(String animalName, String personName);
}
