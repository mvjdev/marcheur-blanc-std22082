package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Marcheur {
    private Lieu position;
    private final Lieu destination;
    private List<Lieu> marche;

    public Marcheur(Lieu destination, Lieu position) {
        this.destination = destination;
        this.position = position;
        this.marche = new ArrayList<>();
    }

    public List<Lieu> marcher(){
        Random random = new Random();

        if(!position.equals(destination)){
            List<Rue> rueAccessibleDepart = position.getListRueAccessible();
            List<Rue> rueAccessibleDestination = destination.getListRueAccessible();

            if (rueAccessibleDepart.isEmpty()){
                System.out.println("Position n'existe pas " + position.getNom());
            }
            if (rueAccessibleDestination.isEmpty()){
                System.out.println("Destination n'existe pas " + destination.getNom());
            }
            Rue rueAleatoireDepart = rueAccessibleDepart.get(random.nextInt(rueAccessibleDepart.size()));
            position = rueAleatoireDepart.depart().equals(position)
                    ? rueAleatoireDepart.arrivee()
                    : rueAleatoireDepart.arrivee();
            marche.add(position);
        }
        return marche;
    }
}