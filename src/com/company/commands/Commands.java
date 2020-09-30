package com.company.commands;

public enum Commands {
    ADD,
    INSERT,
    FEED,
    CALCULATE,
    TREATMENT,
    CHECKTREATMENT,
    ADOPT,
    REPORT,
    EXIT;

    public static boolean checkIsValidCommand(String str) {
        Commands[] types = Commands.values();
        for (Commands dt : types) {
            //Comparing
            if (dt.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
