package test.java;

import org.example.Carte;
import org.example.Lieu;
import org.example.Marcheur;
import org.example.Rue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MarcheurTest {
    private Carte carte;
    private Lieu hei;
    private Lieu esti;

    @BeforeEach
    public void setUp() {
        hei = new Lieu("Hei");
        carte = new Carte(hei);

        carte.ajouterLieu("Hei");
        carte.ajouterLieu("Marais");
        carte.ajouterLieu("Sekolitsika");
        carte.ajouterLieu("Pullman");
        carte.ajouterLieu("Nexta");
        carte.ajouterLieu("Balançoire");
        carte.ajouterLieu("Boulevard de l'europe");
        esti=carte.ajouterLieu("esti");

        carte.ajouterRue("RN1","Marais","Sekolitsika");
        carte.ajouterRue("RN2","Sekolitsika","Hei");
        carte.ajouterRue("RN3","Hei","Balançoire");
        carte.ajouterRue("Rue Andriantsihorana","Hei","Pullman");
        carte.ajouterRue("RN4","Pullman","Balançoire");
        carte.ajouterRue("RN5", "Balançoire", "esti");
        carte.ajouterRue("RN6", "Balançoire", "Boulevard de l'europe");
        carte.ajouterRue("RN7", "Boulevard de l'europe", "esti");

    }

    @Test
    public void test_Bjarni_marche(){
        Marcheur marcheur = new Marcheur(hei,esti);
        marcheur.marcher();

        assertEquals(esti,marcheur.getPosition(),"Esti n'est pas atteind");
    }
}
