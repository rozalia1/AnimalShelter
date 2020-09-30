package com.company.commands;

import com.company.core.Shelter;

import static com.company.messages.ExceptionMessages.INVALID_COMMAND_AND_TYPE;

public class FeedCommand implements Command {
    String[] data;
    String animalName;

    public FeedCommand(String[] data) {
        this.data = data;
    }

    @Override
    public String execute(String command, String type, Shelter shelter) {
        switch(type.toLowerCase()) {
            case "dog":
                animalName = data[0];
                return shelter.feedDog(animalName);
            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND_AND_TYPE, command, type));
        }
    }
}
