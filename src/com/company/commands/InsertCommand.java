package com.company.commands;

import com.company.core.Shelter;

import static com.company.messages.ExceptionMessages.*;

public class InsertCommand implements Command {
    String[] data;
    String cageName;
    String decorationType;

    public InsertCommand(String[] data) {
        this.data = data;
    }

    @Override
    public String execute(String command, String type, Shelter shelter) {
        switch(type.toLowerCase()) {
            case "decoration":
                relateDecorationData(data);
                return shelter.insertDecorationToCage(cageName, decorationType);
            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND_AND_TYPE, command, type));
        }
    }

    private void relateDecorationData(String[] data) {
        cageName = data[0];
        decorationType = data[1];
    }
}
