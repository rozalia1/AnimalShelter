package com.company.commands;

import com.company.core.Shelter;

public interface Command {
    //public String execute(String[] data, DogShelter shelter);
    public String execute(String command, String type, Shelter shelter);
}
