package models;

import java.text.DecimalFormat;

public class Voiture {

    // Attributs :
    private int numero;
    private String nomEquipe;

    // Constructeur:

    public Voiture(int numero, String nomEquipe) {
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }
    // Méthodes:

    public int getNumero() {
        return numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    @Override
    public String toString() {
        DecimalFormat monFormateurNumero = new DecimalFormat("000");

        return "Voiture n°" + monFormateurNumero.format(numero) + " de l'équipe '" + nomEquipe + "'";
    }

}
