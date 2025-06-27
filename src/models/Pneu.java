package models;

import java.text.DecimalFormat;

public class Pneu {
    // Attributs :
    private TypePneu type;
    private double pression;

    // Constructeur:
    public Pneu(TypePneu type, double pression) {
        this.type = type;
        this.pression = pression;
    }

    // Méthodes:

    public TypePneu getType() {
        return type;
    }

    public double getPression() {
        return pression;
    }

    @Override
    public String toString() {

        DecimalFormat monFormateurPression = new DecimalFormat("0.0");
        return "Pneu [type=" + type + ", pression=" + monFormateurPression.format(pression) + "]";
    }

}
