package com.loan.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LoanCalculatorTest {

    private final double TOLERANCE = 0.01;

    @org.junit.Test
    public void shouldReturnCorrectNumberOfPayments() {
        LoanCalculator calculator = new LoanCalculator();
        List<Amortering> plan = calculator.skapaPlan(50000.0, 0.05, 4); // PUNKT
        Assertions.assertEquals(48, plan.size(), "Amorteringsplanen ska ha 48 betalningar.");
    }

    @Test
    void shouldEndWithZeroRemainingBalance() {
        LoanCalculator calculator = new LoanCalculator();
        List<Amortering> plan = calculator.skapaPlan(10000.0, 0.04, 2); // PUNKT

        Amortering lastPayment = plan.get(plan.size() - 1);

        Assertions.assertEquals(0.0, lastPayment.getÅterståendeSkuld(), TOLERANCE, "Skulden ska vara noll efter sista betalningen.");
    }

    @Test
    void shouldCalculateCorrectMonthlyPaymentForKnownCase() {
        LoanCalculator calculator = new LoanCalculator();
        List<Amortering> plan = calculator.skapaPlan(100000.0, 0.05, 5); // PUNKT

        double expectedMonthlyPayment = 1887.12;

        Amortering firstPayment = plan.get(0);

        Assertions.assertEquals(expectedMonthlyPayment, firstPayment.getTotalBetalning(), TOLERANCE,
                "Total månatlig betalning matchar inte standardformeln.");
    }
}
