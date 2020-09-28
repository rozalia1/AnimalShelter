package com.company.enums.dog;


import com.company.enums.cage.CageType;

public enum DogType {
    MINI,
    SMALL,
    BIG;

    public static boolean checkDogType(String str) {
        DogType[] types = DogType.values();
        for (DogType dt : types) {
            //Comparing
            if (dt.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }return false;
    }

}
