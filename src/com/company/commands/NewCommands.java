package com.company.commands;

public enum NewCommands {
    AddCage,
    AddDecoration,
    InsertDecoration,
    AddDog,
    FeedDog,
    CalculateValue,
    SetTreatmentType,
    CheckTreatmentPhase,
    AdoptAnimal,
    Report,
    Exit;

    public static boolean checkIsValidCommand(String str) {
        NewCommands[] types = NewCommands.values();
        for (NewCommands dt : types) {
            //Comparing
            if (dt.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
