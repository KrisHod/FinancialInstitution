package com.go2it;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerService {

    public void applyForMortgage(Customer customer) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the requested mortgage amount");
        int sum = in.nextInt();
        if (customer.isResident() && customer.getCreditScore() > 400 && sum < 3000000) {
            if (customer.getCreditScore() < 600 && sum > 2000000) {
                customer.setMortgage(new Mortgage(sum, 5.5, 120, LocalDate.now().plusDays(5)));
            } else if (customer.getCreditScore() >= 600 && customer.getCreditScore() < 700 && sum <= 2000000 && sum > 1000000) {
                customer.setMortgage(new Mortgage(sum, 3, 120, LocalDate.now().plusDays(5)));
            } else {
                customer.setMortgage(new Mortgage(sum, 1.5, 60, LocalDate.now()));
            }
        } else {
            System.out.println("Sorry, but you're not eligible to get mortgage");
        }
    }

    public boolean applyForCreditLine(Customer customer) {
        return customer.isResident() && customer.getCreditScore() > 700;
    }

    public boolean getPromotion (Customer customer){
        if (customer.getSumWasSpentLastMonth() >= 5000) {
            System.out.println("Congratulation! You get a special promotion");
            return true;
        } else {
            System.out.println("Sorry, you aren't eligible to get special promotion");
            return false;
        }
    }
}
