package test.java;

import org.example.Carte;
import org.example.Lieu;
import org.example.Marcheur;
import org.example.Rue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class MarcheurTest {
    private  static  final Logger logger = Logger.getLogger(MarcheurTest.class.getName());

    public static void main(String[] args){
        LogManager.getLogManager().reset();
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        logger.addHandler(ch);
        logger.setLevel(Level.INFO);

        Carte carte = new Carte();
        Lieu marais = new Lieu("Marais",1);
        Lieu sekolintsika = new Lieu("Sekolintsika",2);
        Lieu hei = new Lieu("Hei",3);
        Lieu pullman = new Lieu("Pullman",4);
        Lieu balançoire = new Lieu("Balançoire",5);
        Lieu nexta = new Lieu("Nexta",5);
        Lieu esti = new Lieu("Esti",6);
        Lieu boulevard = new Lieu("Boulevard de l'Europe",7);

        carte.ajouterLieu(marais);
        carte.ajouterLieu(sekolintsika);
        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(balançoire);
        carte.ajouterLieu(nexta);
        carte.ajouterLieu(esti);
        carte.ajouterLieu(boulevard);

        carte.ajouterRue("Marais","Sekolintsika");
        carte.ajouterRue("Sekolintsika","Hei");
        carte.ajouterRue("Hei","Pullman");
        carte.ajouterRue("Pullman","Balançoire");
        carte.ajouterRue("Pullman","Nexta");
        carte.ajouterRue("Balançoire","Esti");
        carte.ajouterRue("Esti","Boulevard de l'Europe");

        Marcheur bjarni = new Marcheur(carte.getLieu("Hei"));
        List<Lieu> chemin = bjarni.trouverChemin(carte, "Esti");
        if (!chemin.isEmpty()){
            logger.info("Les lieux traversés par Bjarni: " + cheminToString(chemin));
        }else {
            logger.warning("Aucun chemin trouvé");
        }
    }

    private  static String cheminToString(List<Lieu> chemin){
        StringBuilder sb = new StringBuilder();
        for (Lieu lieu : chemin){
            sb.append(lieu.getNom()).append("->");
        }
        sb.delete(sb.length()-4, sb.length());
        return sb.toString();
    }
}
