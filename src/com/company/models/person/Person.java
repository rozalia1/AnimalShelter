package com.company.models.person;

import com.company.models.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;

public class Person {
   private String firstName;
   private String lastName;
   private int age;
   private String telephone;

    Collection<Animal> adoptedAnimals;

    public Person(String firstName, String lastName, int age, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.telephone = telephone;
        this.adoptedAnimals = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Collection<Animal> getAdoptedAnimals() {
        return adoptedAnimals;
    }

    public void adoptAnimal(Animal adoptedAnimal) {
        this.adoptedAnimals.add(adoptedAnimal);
    }

    public boolean checkIsAdult(int targetAge) {
        if (this.age < targetAge) return false;

        return true;
    }
}
