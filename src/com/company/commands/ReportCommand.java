package com.company.commands;

import com.company.core.Shelter;

import static com.company.messages.ExceptionMessages.INVALID_COMMAND_AND_TYPE;

public class ReportCommand implements Command {
    @Override
    public String execute(String command, String type, Shelter shelter) {
        switch(type.toLowerCase()) {
            default:
                return shelter.report();
        }
    }
}
