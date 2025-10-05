package com.loan.calculator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LoanCalculator calculator = new LoanCalculator();

    public static void main(String[] args) {
        System.out.println("===== Lånekalkylator för Amorteringsplan =====");

        try {
            double belopp = läsDouble("Ange lånebelopp: ");
            double ränta = läsDouble("Ange årsränta i procent (t.ex. 5): ");
            int år = läsInt("Ange löptid i år (t.ex. 5): ");

            double årsRäntaDecimal = ränta / 100.0;

            List<Amortering> plan = calculator.skapaPlan(belopp, årsRäntaDecimal, år);
            skrivUtPlan(plan);

        } catch (IllegalArgumentException e) {
            System.err.println("Fel i inmatningen: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ett oväntat fel inträffade: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void skrivUtPlan(List<Amortering> plan) {
        if (plan.isEmpty()) {
            System.out.println("Kunde inte generera en plan.");
            return;
        }

        System.out.println("\n--- Amorteringsplan ---");
        System.out.println("Månad | Datum      | Skuld      | Ränta   | Amortering | Total Bet.");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < plan.size(); i++) {
            Amortering a = plan.get(i);
            System.out.printf("%-5d | %s\n", i + 1, a.toString());
        }
    }


    private static double läsDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value < 0) throw new InputMismatchException("Värdet får inte vara negativt.");
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Ogiltigt format. Skriv in ett positivt nummer (t.ex. 1000).");
                scanner.nextLine();
            }
        }
    }


    private static int läsInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value <= 0) throw new InputMismatchException("Värdet måste vara positivt.");
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Ogiltigt format. Skriv in ett positivt heltal.");
                scanner.nextLine();
            }
        }
    }
}
