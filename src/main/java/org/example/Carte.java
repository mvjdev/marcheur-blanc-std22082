package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Carte {
    private Map<String,Lieu> lieux;
    private final Lieu depart;

    public Carte(Lieu depart) {
        this.depart = depart;
        this.lieux = new HashMap<>();
        lieux.put(depart.getNom(), depart);
    }

    public Lieu ajouterLieu(String nom) {
        if (lieux.containsKey(nom)){
            return lieux.get(nom);
        }
        Lieu lieu = new Lieu(nom);
        lieux.put(nom,lieu);
        return lieu;
    }


    public Rue ajouterRue(String nom,String depart, String arrivee) {
        Lieu lieu1 = lieux.get(depart);
        Lieu lieu2 = lieux.get(arrivee);

        if (lieu1 == null || lieu2 == null) {
            String unLieuEstManquant = (lieu1 == null ? depart: "") +(lieu2 == null ? arrivee: "");
            throw new IllegalArgumentException("Un lieu est manquant" + unLieuEstManquant.trim());
        }

        Rue rue = new Rue(nom,lieu1,lieu2);
        lieu1.ajouterUnRue(rue);
        lieu2.ajouterUnRue(rue);

        return rue;
    }
}
