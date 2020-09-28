package com.company.enums;

import com.company.enums.dog.DogType;

public enum TreatmentType {
    NONE,
    VACCINATION,
    DEWORMING,
    OPERATION;

    public static boolean checkTreatmentType(String str) {
        TreatmentType[] types = TreatmentType.values();
        for (TreatmentType dt : types) {
            //Comparing
            if (dt.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }return false;
    }
}
