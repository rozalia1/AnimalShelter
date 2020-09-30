package com.company.commands;

import com.company.core.Shelter;
import static com.company.messages.ExceptionMessages.*;

public class AddCommand implements Command {
    private String[] data;
    private String cageName;
    private String cageType;
    private String decorationType;
    private String animalType;
    private String animalName;
    private String animalSpecies;
    private double animalPrice;

    public AddCommand(String[] data) {
        this.data = data;
    }

    @Override
    public String execute(String command, String type, Shelter shelter) {
        switch(type.toLowerCase()) {
            case "dog":
                relateDogData(data);
                return shelter.addDog(cageName, animalType, animalName, animalSpecies, animalPrice);
            case "cage":
                relateCageData(data);
                return shelter.addCage(cageName, cageType);
            case "decoration":
                decorationType = data[0];
                return shelter.addDecoration(decorationType);
            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND_AND_TYPE, command, type));
        }
    }

    private void relateDogData(String[] data) {
        cageName = data[0];
        animalType = data[1];
        animalName = data[2];
        animalSpecies = data[3];
        animalPrice = Double.parseDouble(data[4]);
    }

    private void relateCageData(String[] data) {
        cageType = data[0];
        cageName = data[1];
    }
}
