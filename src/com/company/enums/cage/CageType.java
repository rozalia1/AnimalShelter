package com.company.enums.cage;

public enum CageType {
    NONE,
    SMALL,
    BIG;

    public static boolean checkCageType(String str) {
        CageType[] types = CageType.values();
        for (CageType ct : types) {
            //Comparing
            if (ct.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }return false;
    }
}
