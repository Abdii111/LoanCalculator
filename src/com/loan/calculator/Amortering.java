package com.loan.calculator;

import java.time.LocalDate;

public class Amortering {
    private final LocalDate datum;
    private final double återståendeSkuld;
    private final double ränta;
    private final double amortering;
    private final double totalBetalning;

    public Amortering(LocalDate datum, double återståendeSkuld, double ränta, double amortering, double totalBetalning) {
        this.datum = datum;
        this.återståendeSkuld = återståendeSkuld;
        this.ränta = ränta;
        this.amortering = amortering;
        this.totalBetalning = totalBetalning;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public double getÅterståendeSkuld() {
        return återståendeSkuld;
    }

    public double getRänta() {
        return ränta;
    }

    public double getAmortering() {
        return amortering;
    }

    public double getTotalBetalning() {
        return totalBetalning;
    }


    @Override
    public String toString() {
        return String.format(
                "%s | Skuld: %-10.2f | Ränta: %-8.2f | Amortering: %-8.2f | Totalt: %.2f",
                datum, återståendeSkuld, ränta, amortering, totalBetalning
        );
    }
}