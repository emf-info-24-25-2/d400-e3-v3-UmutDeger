package app;

import models.Pilote;
import models.Pneu;
import models.TypePneu;
import models.Voiture;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------

        Voiture v1 = new Voiture(16, "Ferrari");

        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------

        System.out.println(v1);

        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------

        Pilote p1 = new Pilote("Charles Leclerc", "Monégasque", v1);
        p1.getNombrePneusEnReserve();
        p1.setNombreCourses(16);
        p1.setNombrePoints(65);
        p1.setNombreVictoires(3);
        p1.setNombrePodiums(7);

        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------

        System.out.println(p1);

        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        Pneu pn1 = new Pneu(TypePneu.DUR_BLANC, 1.5);

        Pneu pn2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);

        Pneu pn3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);

        Pneu pn4 = new Pneu(TypePneu.DUR_BLANC, 1.6);

        Pneu pn5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);

        // deposerPneuEnReserve() 5 fois de types différents

        p1.deposerPneuEnReserve(pn1);
        p1.deposerPneuEnReserve(pn2);
        p1.deposerPneuEnReserve(pn3);
        p1.deposerPneuEnReserve(pn4);
        p1.deposerPneuEnReserve(pn5);

        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher

        p1.retirerPneuEnReserve(null)

        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve

        // getPneusEnReserveSansTrous() et afficher les pneus en réserve

        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne
        // des
        // pneus

        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC

        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué

        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés

        // ---------------------------------------------------------------------------------------

    }

}
