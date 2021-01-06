package com.go2it.service;

import com.go2it.entities.Customer;

public class CustomerService {



    public boolean applyForCreditLine(Customer customer) { //applyForCreditLine based on the name should do something else.
        // Here you just check if the client is eligible. Thus, the naming should be corresponding.
        // Otherwise, you can return the CreditCard instance
        return customer.isResident() && customer.getCreditScore() > 700;
    }

    public boolean getPromotion (Customer customer){
        if (customer.getSpentLastMonth() >= 5000) {
            System.out.println("Congratulation! You get a special promotion");
            return true;
        } else {
            System.out.println("Sorry, you aren't eligible to get special promotion");
            return false;
        }
    }
}
