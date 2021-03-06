package com.company.commands;

import com.company.core.Shelter;

public class ReportCommand implements ICommand {
    @Override
    public String execute(Shelter shelter, String[] data) {
        return shelter.report();
    }
}
