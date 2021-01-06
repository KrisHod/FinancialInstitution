package com.go2it;

import com.go2it.entities.*;
import com.go2it.service.CheckingAccountService;
import com.go2it.service.CreditCardService;
import com.go2it.service.CreditLineService;
import com.go2it.service.MortgageService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        customer.setDateBecomeCustomer(LocalDate.of(2010, 6, 19));
        customer.setStudent(true);

        //Check mortgage functionality
        MortgageService mortgageService = new MortgageService();
        try {
            Mortgage mortgage = mortgageService.applyCreditProduct(customer);
            mortgageService.applyPromotion(customer, mortgage);
            System.out.println(mortgage);
            System.out.println("Your monthly payment will be " + String.format("%.2f", mortgageService.getMonthlyPayment(mortgage)));
            System.out.println("Your total payment will be " + String.format("%.2f", mortgageService.getTotalPayment(mortgage)));
            mortgageService.getMonthlyPaymentCalendar(mortgage);

        } catch (NotEligibleCustomerException e) {
            System.out.println(e.getMessage());
        }

        //Check checking account functionality
        CheckingAccountService checkingAccountService = new CheckingAccountService();
        try {
            CheckingAccount checkingAccount = new CheckingAccount(32098, 69);
            checkingAccountService.applyPromotion(customer, checkingAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Check credit card functionality
        CreditCardService creditCardService = new CreditCardService();
        try {
            CreditCard creditCard = creditCardService.applyCreditProduct(customer);
            creditCardService.applyPromotion(customer, creditCard);
            System.out.println(creditCard);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//Check credit line functionality
        CreditLineService creditLineService = new CreditLineService();
        try {
            CreditLine creditLine = creditLineService.applyCreditProduct(customer);
            System.out.println(creditLine);
            creditLineService.applyPromotion(customer, creditLine);
            System.out.println(creditLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
