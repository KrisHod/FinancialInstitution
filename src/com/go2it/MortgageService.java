package com.go2it;


import java.time.LocalDate;

public class MortgageService {
    public double getMonthlyPayment(Mortgage mortgage) {
        double monthlyInterestRate = mortgage.getInterestRate() / 1200;
        return mortgage.getSum() * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, mortgage.getNumMonths())));
    }

    public double getTotalPayment(Mortgage mortgage) {
        return getMonthlyPayment(mortgage) * mortgage.getNumMonths();
    }

    public LocalDate getDateEnd(Mortgage mortgage) {
        return mortgage.getDateStart().plusMonths(mortgage.getNumMonths());
    }
}
