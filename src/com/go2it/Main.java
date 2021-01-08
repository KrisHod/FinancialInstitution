package com.go2it;

import com.go2it.entities.*;
import com.go2it.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        customer.setDateBecomeCustomer(LocalDate.of(2010, 6, 19));
        customer.setStudent(true);

        //Check mortgage functionality
        MortgageService mortgageService = new MortgageService();
        try {
            Mortgage mortgage = mortgageService.applyCreditProduct(customer);
            mortgageService.applyPromotion(mortgage);
            System.out.println(mortgage);
            System.out.println("Your monthly payment will be " + String.format("%.2f", mortgageService.getMonthlyPayment(mortgage)));
            System.out.println("Your total payment will be " + String.format("%.2f", mortgageService.getTotalPayment(mortgage)));
            mortgageService.getMonthlyPaymentCalendar(mortgage);

            //Check checking account functionality
            CheckingAccountService checkingAccountService = new CheckingAccountService();
            CheckingAccount checkingAccount = new CheckingAccount(customer, 32098, 69);
            checkingAccountService.applyPromotion(checkingAccount);

            //Check credit card functionality
            CreditCardService creditCardService = new CreditCardService();
            CreditCard creditCard = creditCardService.applyCreditProduct(customer);
            creditCardService.applyPromotion(creditCard);
            System.out.println(creditCard);

            //Check credit line functionality
            CreditLineService creditLineService = new CreditLineService();
            CreditLine creditLine = creditLineService.applyCreditProduct(customer);
            System.out.println(creditLine);
            creditLineService.applyPromotion(creditLine);
            System.out.println(creditLine);

            List<BankProduct> productList = new ArrayList<>();
            productList.add(mortgage);
            productList.add(creditLine);
            productList.add(creditCard);
            for (BankProduct prodct : productList) {

                mortgageService.applyPromotion(prodct);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
