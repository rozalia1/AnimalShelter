package com.company.commands;

import com.company.core.Shelter;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private static final Map<String, ICommand> commands = new HashMap<>();
    static {
        commands.put("AddDog", new AddDogCommand());
        commands.put("AddCage", new AddCageCommand());
    }

    public String executeCommand(String command, Shelter shelter, String[] data) {
        return commands.get(command).execute(shelter, data);
    }
}
