package org.example;

import java.util.HashMap;
import java.util.Map;

public class Carte {
    Map<String,Lieu> lieux;

    public Carte() {
        lieux = new HashMap<>();
    }

    public void ajouterLieu(Lieu lieu) {
        lieux.put(lieu.getNom(), lieu);
    }

    public void ajouterRue(String nomLieuDepart, String nomLieuDestination) {
        Lieu depart = lieux.get(nomLieuDepart);
        Lieu destination = lieux.get(nomLieuDestination);

        if(depart != null && destination != null) {
            depart.ajouterRue(new Rue(destination));
        }
    }

    public Lieu getLieu(String nom) {
        return lieux.get(nom);
    }
}
