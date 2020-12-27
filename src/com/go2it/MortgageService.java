package com.go2it;

import java.time.LocalDate;
import java.time.Period;

public class MortgageService {
    private Mortgage mortgage;

    public Mortgage getMortgage() {
        return mortgage;
    }

    public void setMortgage(Mortgage mortgage) {
        this.mortgage = mortgage;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = mortgage.getInterestRate() / 1200;
        double monthlyPayment = mortgage.getSum() * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, mortgage.getNumMonths())));
        return monthlyPayment;
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * mortgage.getNumMonths();
        return totalPayment;
    }

    public LocalDate getDateEnd() {
        return mortgage.getDateStart().plusMonths(mortgage.getNumMonths());
    }
}
