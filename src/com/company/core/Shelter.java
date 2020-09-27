package com.company.core;

import com.company.enums.TreatmentType;
import com.company.models.animals.Animal;

public interface Shelter {
    String report();
    String setSickAnimal(Animal a, TreatmentType treatType);
    String treatAnimal(Animal a, TreatmentType treatType);
    boolean isCured();
}
