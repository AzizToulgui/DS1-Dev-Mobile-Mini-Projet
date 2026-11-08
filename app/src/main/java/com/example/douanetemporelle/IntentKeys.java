package com.example.douanetemporelle;

public class IntentKeys {
    public static String createKey(String matricule, String name){
        String lastFour = matricule.substring(matricule.length()-4);
        return lastFour + "_" + name;
    }
}
