package com.go2it;

import com.go2it.entities.*;
import com.go2it.service.CustomerService;
import com.go2it.service.MortgageService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John", 6000, 560, true);
        customer.setDateBecomeCustomer(LocalDate.of(2010,6,19));

        //Checking mortgage functionality
        MortgageService mortgageService = new MortgageService();
        try {
            Mortgage mortgage = mortgageService.applyCreditProduct(customer);
            mortgageService.applyPromotion(customer,mortgage);
            System.out.println(mortgage);
            System.out.println("Your monthly payment will be " + String.format("%.2f",mortgageService.getMonthlyPayment(mortgage)));
            System.out.println("Your total payment will be " + String.format("%.2f",mortgageService.getTotalPayment(mortgage)));

        } catch (NotEligibleCustomerException e) {
            e.getMessage();
        }




//        CreditLine creditLine = new CreditLine(2000, 2.2, 30);
//
//        CreditCard card = new CreditCard("1111222233334444", "1234", creditLine);
//





    }
}
