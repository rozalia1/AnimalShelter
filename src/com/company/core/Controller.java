package com.company.core;

public interface Controller {
    String add(Object obj);
    String addCage(String cageType, String cageName);
    String addDecoration(String type);
    String insertDecoration(String cageName, String decorationType);
    String addDog(String cageName, String dogType, String dogName, String dogSpecies, double price);
    String feedDog(String dogName);
    String calculateValue(String cageName);
    String report();
}
