package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Lieu {
    String nom;
    int valeur;
    List<Rue> rues;

    public Lieu(String nom, int valeur) {
        this.nom = nom;
        this.valeur = valeur;
        rues = new ArrayList<>();
    }
    public void ajouterRue(Rue rue) {
        rues.add(rue);
    }
    public String getNom() {
        return nom;
    }
    public int getValeur() {
        return valeur;
    }
    public List<Rue> getRues() {
        return rues;
    }
}
