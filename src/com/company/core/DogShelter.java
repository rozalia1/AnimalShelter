package com.company.core;

import com.company.enums.TreatmentPhase;
import com.company.enums.TreatmentType;
import com.company.enums.dog.DogType;
import com.company.models.animals.Animal;
import com.company.models.animals.Dog;
import com.company.models.cage.CageController;
import com.company.models.cage.DogCage;
import com.company.models.decoration.Decoration;
import com.company.models.person.Person;
import com.company.repositories.DecorationRepo;

import java.util.ArrayList;
import java.util.Collection;

import static com.company.messages.ConstantMessages.*;
import static com.company.messages.ExceptionMessages.*;

public class DogShelter implements Shelter {
    DecorationRepo decorationRepo;
    Collection<DogCage> cages;
    Collection<Dog> dogs;
    Collection<Dog> sickDogs;
    Collection<Dog> adoptedDogs;
    Collection<Person> people;

    CageController cageController;

    public DogShelter() {
        this.decorationRepo = new DecorationRepo();
        this.cages = new ArrayList<>();
        this.dogs = new ArrayList<>();
        this.sickDogs = new ArrayList<Dog>();
        this.cageController = new CageController();
        this.adoptedDogs = new ArrayList<Dog>();
    }

    public DecorationRepo getDecorations() {
        return decorationRepo;
    }

    public Collection<DogCage> getCages() {
        return cages;
    }

    public Collection<Dog> getDogs() {
        return dogs;
    }

    public Collection<Dog> getSickDogs() {
        return sickDogs;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (DogCage cage : cages) {
            sb.append(cage.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String addCage(String cageName, String cageType) {
        // check if there is another cage with this name, if so throw exception
        cages.add(cageController.createCage(cageName, cageType));
        return String.format(SUCCESSFULLY_ADDED_CAGE_WITH_CAGETYPE, cageName,cageType);
    }

    @Override
    public String addDecoration(String type) {
        decorationRepo.addDecorationByType(type);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecorationToCage(String cageName, String decorationType) {
        Decoration dec = decorationRepo.findByType(decorationType);
        if (dec == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        DogCage cage = cageController.findCageByName(cageName, cages);
        cage.addDecoration(decorationType, decorationRepo);
        decorationRepo.remove(dec);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_CAGE, decorationType, cageName);
    }

    @Override
    public String addDog(String cageName, String dogType, String dogName, String dogSpecies, double price) {
        if (!DogType.checkDogType(dogType)) {
            throw new IllegalArgumentException(INVALID_DOG_TYPE);
        }
        dogType = dogType.toUpperCase();

        Dog createdDog = new Dog(dogName, price, DogType.valueOf(dogType), dogSpecies);
        dogs.add(createdDog);
        for(DogCage cage : cages) {
            if (cage.getName().toLowerCase() == cageName.toLowerCase()) {
                cage.addAnimal(createdDog);
            }
        }

        return String.format(SUCCESSFULLY_ADDED_DOG_IN_CAGE, dogName, cageName);

    }

    @Override
    public String feedDog(String cageName) {
        DogCage cage = this.cages.stream().filter(c -> c.getName().equals(cageName)).findFirst().orElse(null);
        cage.feedDogs();

        int count = cage.getAnimals().size();
        return String.format(DOGS_FED, count);
    }

    @Override
    public String treatAnimal(Animal a) {
        if (a.getTreatPhase() != TreatmentPhase.NONE) throw new IllegalArgumentException(ANIMAL_IS_UNDER_TREATMENT);
        a.setTreatPhase(TreatmentPhase.CURE);
        return null;
    }

    @Override
    public String treatAnimals() {
        for (Dog sickDog : sickDogs) {
            if (sickDog.getTreatPhase() == TreatmentPhase.CURE) sickDog.setTreatPhase(TreatmentPhase.STARTED);
        }

        return null;
    }

    @Override
    public boolean isCured(Animal a) {
        if (a.getTreatPhase() == TreatmentPhase.CURED || a.getTreatPhase() == TreatmentPhase.NONE) return true;

        return false;
    }

    @Override
    public String setTreatmentType(String  animalName, String treatType) {
        if(!TreatmentType.checkTreatmentType(treatType))
            throw new  IllegalArgumentException(String.format(INVALID_TREATMENT_TYPE, treatType));

        Dog d1 = (Dog) findAnimal(animalName);

        treatType = treatType.toUpperCase();
        d1.setTreatType(TreatmentType.valueOf(treatType));
        d1.setTreatPhase(TreatmentPhase.CURE);
        sickDogs.add(d1);
        dogs.remove(d1);

        return String.format(SUCCESSFULLY_ADDED_SICK_ANIMAL, animalName);
    }

    public String checkTreatmentPhase(String animalName){
        Dog d1 = (Dog) findAnimal(animalName);
        switch (d1.getTreatPhase()){
            case STARTED:
            case PROGRESS:
            case CURE:
                return String.format(TREATMENT_PHASE,animalName,d1.getTreatPhase());
            case CURED:
                return String.format(TREATMENT_PHASE_CURED,animalName,d1.getTreatPhase());
            case NONE:
                return String.format(ANIMAL_IS_HEALTHY, animalName);
        }
        return String.format(ANIMAL_IS_HEALTHY,animalName);
    }

    public void addSickDog(Dog sickDog) {
        this.sickDogs.add(sickDog);
    }

    @Override
    public String adoptAnimal(String animalName, String personName) {
        Dog d1 = (Dog) findAnimal(animalName);
        if(isCured(d1)){
            adoptedDogs.add(d1);
            dogs.remove(d1);
            return String.format(ADOPTED_ANIMAL, animalName, personName);
        }

        return String.format(ANIMAL_IS_UNDER_TREATMENT);
    }

    public String calculateValue(String cageName) {
        return cageController.calculateValue(cageName, cages);
    }

    private Animal findAnimal(String animalName) {
        Dog searchedDog = null;
        for (Dog dog : dogs) {
            if (dog.getName().equals(animalName)) searchedDog = dog;
        }

        if (searchedDog == null) throw new IllegalArgumentException();

        return searchedDog;
    }
}