package com.company.core;

import com.company.models.animals.Animal;

public interface Shelter {
    String addCage(String cageName, String cageType);
    String addDecoration(String type);
    String insertDecorationToCage(String cageName, String decorationType);
    String addDog(String cageName, String dogType, String dogName, String dogSpecies, double price);
    String feedDog(String cageName);
    String report();
    String setTreatmentType(String animalName, String treatType);
    String treatAnimal(Animal a);
    String treatAnimals();
    boolean isCured(Animal a);
    String adoptAnimal(String animalName, String personName);
}
