package models;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Pilote {

    // Attributs :

    public static final int NOMBRE_PNEUS_EN_RESERVE = 16;

    private final String nom;

    private final String nationalite;

    private int nombrePoints;

    private int nombreCourses;

    private int nombreVictoires;

    private int nombrePodiums;

    private final Pneu[] pneusEnReserve;

    private final Voiture voiture;

    // ConstructeurS:

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = null;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.voiture = voiture;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
    }

    // Méthodes:

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean deposable = false;
        if (pneu != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] == null) {
                    pneusEnReserve[i] = pneu;
                    break;
                }
            }
        }
        return deposable;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu pneuTrouvee = null;
        if (type != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] != null && pneusEnReserve[i].getType().equals(type)) {
                    pneuTrouvee = pneusEnReserve[i];
                    pneusEnReserve[i] = null;
                    break;

                }
            }
        }
        return pneuTrouvee; // !!!!!!!!!!! MODIFIER UMUT
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {

        int nbrePneuDeCeType = 0;

        if (type != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] != null && pneusEnReserve[i].getType().equals(type)) {
                    nbrePneuDeCeType++;
                }
            }
        }
        return nbrePneuDeCeType;
    }

    public int getNombrePneusEnReserve() {

        int nbrePneuEnReserve = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                nbrePneuEnReserve++;
            }
        }
        return nbrePneuEnReserve;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        int nbrePneuEnReserve = this.getNombrePneusEnReserve();

        Pneu[] tabSansTrouPneus = new Pneu[nbrePneuEnReserve];
        int pos = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                tabSansTrouPneus[pos] = pneusEnReserve[i];
                pos++;
            }

        }
        return tabSansTrouPneus;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {

        int nbrePneuEnReserve = this.getNombrePneusEnReserve();
        Pneu[] tabSansTrouPneus = new Pneu[nbrePneuEnReserve];
        int pos = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                tabSansTrouPneus[pos] = pneusEnReserve[i];
            }

        }

        String resultat;
        double pressionTotal = 0.00;
        for (int i = 0; i < tabSansTrouPneus.length; i++) {
            pressionTotal = pressionTotal + tabSansTrouPneus[i].getPression();
        }

        int nbrePneuTotal = tabSansTrouPneus.length;

        double moyennnePression = pressionTotal / nbrePneuTotal;

        DecimalFormat monFormateurMoyennePression = new DecimalFormat("0.00");

        resultat = "Pression moyenne des pneus en réserve : " + monFormateurMoyennePression.format(moyennnePression);

        return resultat;

    }

    public int supprimerPneusDePressionInferieure(double pression) {
        int nbrePneuEnReserve = this.getNombrePneusEnReserve();
        Pneu[] tabSansTrouPneus = new Pneu[nbrePneuEnReserve];
        int pos = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                tabSansTrouPneus[pos] = pneusEnReserve[i];
            }

        }

        double pressionTotal = 0.00;
        for (int i = 0; i < tabSansTrouPneus.length; i++) {
            pressionTotal = pressionTotal + tabSansTrouPneus[i].getPression();
        }

        int nbrePneuTotal = tabSansTrouPneus.length;

        double moyennnePression = pressionTotal / nbrePneuTotal;

        int nbrePneuInferieurMoyenne = 0;

        for (int i = 0; i < tabSansTrouPneus.length; i++) {
            if (tabSansTrouPneus[i].getPression() < moyennnePression) {
                tabSansTrouPneus[i] = null;
                nbrePneuInferieurMoyenne++;
            }
        }
        return nbrePneuInferieurMoyenne;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        boolean ajoutReussi = false;

        int nbrePneuEnReserve = this.getNombrePneusEnReserve();
        int capaciteReservePneu = pneusEnReserve.length;

        int nbrePlaceDispoDansPneuReserve = capaciteReservePneu - nbrePneuEnReserve;

        if (pneus != null) {

            int nbrePneuDansLot = 0;
            for (int i = 0; i < pneus.length; i++) {
                if (pneus[i] != null) {
                    nbrePneuDansLot++;
                }
            }

            Pneu[] tabSansTrouPneusDansLot = new Pneu[nbrePneuDansLot];
            int pos = 0;
            for (int i = 0; i < pneus.length; i++) {
                if (pneus[i] != null) {
                    tabSansTrouPneusDansLot[pos] = pneus[i];
                    pos++;
                }
            }

            if (nbrePneuDansLot <= nbrePlaceDispoDansPneuReserve) {

                int k = 0;
                for (int i = 0; i < pneusEnReserve.length; i++) {
                    if (pneusEnReserve[i] == null) {
                        pneusEnReserve[i] = tabSansTrouPneusDansLot[k];
                        k++;
                    }
                    ajoutReussi = true;
                }

            } else if (nbrePneuDansLot > nbrePlaceDispoDansPneuReserve) {

                ajoutReussi = false;

            }

        }
        return ajoutReussi;

    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {

        String resultat = "Pilote: " + nom + " (" + nationalite + ")\n";

        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();
            resultat += "-> Voiture " + nomEquipe + "(" + numero + ")\n";
            resultat += "-> Points : " + nombrePoints + "\n";
            resultat += "-> Courses: " + nombreCourses + "\n";
            resultat += "-> Victoires: " + nombreVictoires + "\n";
            resultat += "-> Podiums: " + nombrePodiums + "\n";
        } else {
            resultat += "-> Pas de voiture assignée.\n";
        }

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "-> Pneu en réserve : " + type + "\n";
            }
        }

        return resultat;
    }

}
