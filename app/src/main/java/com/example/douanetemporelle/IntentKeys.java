package com.example.douanetemporelle;

// sna3na fonction traja3 les 4 nombres le5renin mtaa l matricule maa nom du voyageur
public class IntentKeys {
    public static String createKey(String matricule, String name){
        String lastFour = matricule.substring(matricule.length()-4);
        return lastFour + "_" + name;
    }
}
