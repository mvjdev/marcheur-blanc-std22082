package org.example;

import java.util.*;
import java.util.logging.Logger;

public class Marcheur {
    private static final Logger logger = Logger.getLogger(Marcheur.class.getName());
    Lieu positionActuelle;

    public Marcheur (Lieu lieuDeDepart) {
        this.positionActuelle = lieuDeDepart;
        logger.info("Départ de Bjarni à: " + lieuDeDepart.getNom());
    }
    public List<Lieu> trouverChemin(Carte carte, String destinationNom){
        Lieu destination = carte.getLieu(destinationNom);

        if(destination == null){
            logger.info("Destination inconnue: " + destinationNom);
            return Collections.emptyList();
        }

        Queue<List<Lieu>> queue = new LinkedList<>();
        Set<Lieu> visites = new HashSet<>();

        List<Lieu> cheminInitial = new ArrayList<>();
        cheminInitial.add(positionActuelle);
        queue.add(cheminInitial);

        while (!queue.isEmpty()){
            List<Lieu> chemin = queue.poll();
            Lieu dernierLieu = chemin.get(chemin.size() -1);

            if (dernierLieu.equals(destination)){
                logger.info("Chemin trouvé: " + cheminToString(chemin));
                return chemin;
            }
            visites.add(dernierLieu);

            for (Rue rue: dernierLieu.getRues()){
                Lieu prochainLieu = rue.getDestination();

                if(!visites.contains(prochainLieu)){
                    List<Lieu> nouveauChemin = new ArrayList<>(chemin);
                    nouveauChemin.add(prochainLieu);
                    queue.add(nouveauChemin);
                }
            }
        }
        logger.warning("Aucun chemin trouvé vers: " + destinationNom);
        return Collections.emptyList();
    }

    private String cheminToString(List<Lieu> chemin){
        StringBuilder sb = new StringBuilder();
        for (Lieu lieu: chemin){
            sb.append(lieu.getNom()).append("->");
        }
        sb.delete(sb.length()-4, sb.length());
        return sb.toString();
    }
}