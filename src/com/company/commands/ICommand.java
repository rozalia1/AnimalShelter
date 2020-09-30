package com.company.commands;

import com.company.core.Shelter;

public interface ICommand {
    public String execute(Shelter shelter, String[] data);
}
