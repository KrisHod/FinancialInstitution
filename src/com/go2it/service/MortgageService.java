package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MortgageService extends CreditProductService {

    public int getRequestedAmountFromUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the requested mortgage amount");
        return in.nextInt();
    }

    /**
     * create a mortgage according to the conditions
     */
    @Override
    public Mortgage applyCreditProduct(Customer customer) throws NotEligibleCustomerException {
        int sum = getRequestedAmountFromUser();
        if (isEligibleForCreditProduct(customer)) {
            if (customer.getCreditScore() < 600 && sum > 3000000) {
                return new Mortgage(customer, 5.5, sum, 120, LocalDate.now().plusDays(5));
            } else if (customer.getCreditScore() >= 600 && customer.getCreditScore() < 700
                    && sum <= 2000000 && sum > 1000000) {
                return new Mortgage(customer, 3, sum, 120, LocalDate.now().plusDays(5));
            } else {
                return new Mortgage(customer, 1.5, sum, 60, LocalDate.now());
            }
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply mortgage");
        }
    }

    @Override
    public boolean isPromotionEligible(Customer customer) {
        long monthsOurClient = customer.getNumberMonthsOurClient();
        return monthsOurClient > 24;
    }

    /**
     * if the customer is eligible to the promotion, reduce his interest rate
     */
    @Override
    public void applyPromotion(BankProduct product) throws NotEligibleCustomerException {
        if (!(product instanceof Mortgage)) {
            throw new ClassCastException();
        }
            Mortgage mortgage = (Mortgage) product;

//        if (mortgage instanceof Mortgage){   //I would use the instanceOf or getClass() to check if it is the Mortgage.
//        Otherwise, ClassCastException will be thrown in runtime
        if (isPromotionEligible(mortgage.getCustomer())) {
            double newInterestRate = mortgage.getInterestRate() - 0.5;
            System.out.println("Your interest rate changed from " + mortgage.getInterestRate() + " to " + newInterestRate);
            mortgage.setInterestRate(newInterestRate);
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
    }

    public double getMonthlyPayment(Mortgage mortgage) {
        // formula to calculate a monthly mortgage payment
        double monthlyInterestRate = mortgage.getInterestRate() / 1200;
        return mortgage.getSum() * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, mortgage.getNumMonths())));
    }

    public double getTotalPayment(Mortgage mortgage) {
        return getMonthlyPayment(mortgage) * mortgage.getNumMonths();
    }

    public void getMonthlyPaymentCalendar(Mortgage mortgage) {
        Period period = Period.ofMonths(1);
        LocalDate startDate = mortgage.getDateStart();
        while (startDate.isBefore(mortgage.calculateEndDate())) {
            startDate = startDate.plus(period);
            System.out.println("Date of your next payment is " + startDate);
        }
    }
}
