package com.company.commands;

import com.company.core.Shelter;

public class AddCageCommand implements ICommand {
    @Override
    public String execute(Shelter shelter, String[] data) {
        return shelter.addCage(data);
    }
}
