package com.go2it;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        MortgageService mortgageService = new MortgageService();

        CreditLine creditLine = new CreditLine(2000, 2.2, 30);

        CreditCard card = new CreditCard("1111222233334444", "1234", creditLine);

        Customer customer = new Customer("John", 6000, 560, true);

        customerService.applyForCreditLine(customer);
        customerService.applyForMortgage(customer);
        customerService.getPromotion(customer);

        System.out.println(customer.getMortgage());

        System.out.println(customer);

        System.out.println("Your mortgage will end on " + mortgageService.getDateEnd(customer.getMortgage()));
        System.out.println("Your monthly payment will be " + mortgageService.getMonthlyPayment(customer.getMortgage()));
        System.out.println("Your total payment will be " + mortgageService.getTotalPayment(customer.getMortgage()));
    }
}
