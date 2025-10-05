package com.loan.calculator;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class LoanCalculator {

    public List<Amortering> skapaPlan(double belopp, double årsRäntaDecimal, int antalÅr) {
        if (belopp <= 0 || antalÅr <= 0) {
            throw new IllegalArgumentException("Belopp och år måste vara positiva.");
        }

        List<Amortering> plan = new ArrayList<>();


        int antalBetalningar = antalÅr * 12;
        double månadsRänta = årsRäntaDecimal / 12;
        double återståendeSkuld = belopp;


        double månatligBetalning;
        if (månadsRänta == 0) {
            månatligBetalning = belopp / antalBetalningar;
        } else {
            double faktor = Math.pow(1 + månadsRänta, antalBetalningar);
            månatligBetalning = belopp * (månadsRänta * faktor) / (faktor - 1);
        }


        LocalDate datum = LocalDate.now().plusMonths(1).withDayOfMonth(1);



        for (int i = 0; i < antalBetalningar; i++) {
            double ränteDel = återståendeSkuld * månadsRänta;


            double amorteringsDel = månatligBetalning - ränteDel;

            double aktuellTotalBetalning = månatligBetalning;

            if (i == antalBetalningar - 1) {
                amorteringsDel = återståendeSkuld;

                aktuellTotalBetalning = ränteDel + amorteringsDel;

                återståendeSkuld = 0;
            } else {
                återståendeSkuld -= amorteringsDel;
            }

            plan.add(new Amortering(
                    datum,
                    återståendeSkuld,
                    ränteDel,
                    amorteringsDel,
                    aktuellTotalBetalning
            ));

            datum = datum.plusMonths(1);
        }

        return plan;
    }
}
