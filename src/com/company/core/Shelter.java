package com.company.core;

import com.company.models.animals.Animal;

public interface Shelter {
    String addCage(String[] data);
    String addDecoration(String type);
    String insertDecorationToCage(String cageName, String decorationType);
    String addDog(String[] data);
    String feedDog(String cageName);
    String report();
    String setTreatmentType(String animalName, String treatType);
    String treatAnimal(Animal a);
    String treatAnimals();
    boolean isCured(Animal a);
    String adoptAnimal(String animalName, String personName);
}
