package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Lieu {
    private final String nom;

    private List<Rue> listRueAccessible;

    public Lieu(String nom) {
        this.nom = nom;
        this.listRueAccessible = new ArrayList<>();
    }

    public void ajouterUnRue(Rue rue) {
        if (!listRueAccessible.contains(rue)) {
            listRueAccessible.add(rue);
        }
    }
}
