package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.BankProduct;
import com.go2it.entities.CreditProduct;
import com.go2it.entities.Customer;
import com.go2it.entities.Mortgage;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MortgageService extends CreditProductService {
    /**
     * calculate how many months a person has been our customer
     */
    private long getNumberMonthsOurClient(Customer customer) {
        Period diff = Period.between(customer.getDateBecomeCustomer(), LocalDate.now());
        return diff.toTotalMonths();
    }

    /**
     * create a mortgage according to the conditions
     */
    @Override
    public Mortgage applyCreditProduct(Customer customer) throws NotEligibleCustomerException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the requested mortgage amount");
        int sum = in.nextInt();
        if (isEligibleForCreditProduct(customer)) {
            if (customer.getCreditScore() < 600 && sum > 3000000) {
                return new Mortgage(sum, 5.5, 120, LocalDate.now().plusDays(5));
            } else if (customer.getCreditScore() >= 600 && customer.getCreditScore() < 700 && sum <= 2000000 && sum > 1000000) {
                return new Mortgage(sum, 3, 120, LocalDate.now().plusDays(5));
            } else {
                return new Mortgage(sum, 1.5, 60, LocalDate.now());
            }
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply mortgage");
        }
    }

    @Override
    public boolean isPromotionEligible(Customer customer) {
        long monthsOurClient = getNumberMonthsOurClient(customer);
        return monthsOurClient > 24;
    }

    /**
     * if the customer is eligible to the promotion, reduce his interest rate
     */
    @Override
    public void applyPromotion(Customer customer, BankProduct product) throws NotEligibleCustomerException {
        Mortgage mortgage = (Mortgage) product;

        if (isPromotionEligible(customer)) {
            double newInterestRate =mortgage.getInterestRate() - Mortgage.getPromotionalReduceRate();
            System.out.println("Your interest rate changed from " + mortgage.getInterestRate() + " to " + newInterestRate);
            mortgage.setInterestRate(newInterestRate);
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
    }

    public double getMonthlyPayment(Mortgage mortgage) {
        double monthlyInterestRate = mortgage.getInterestRate() / 1200;
        return mortgage.getSum() * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, mortgage.getNumMonths()))); // formula to calculate a monthly mortgage payment
    }

    public double getTotalPayment(Mortgage mortgage) {
        return getMonthlyPayment(mortgage) * mortgage.getNumMonths();
    }
}
