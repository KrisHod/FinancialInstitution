package com.go2it.service;

import com.go2it.entities.CreditProduct;
import com.go2it.entities.Customer;
import com.go2it.entities.Mortgage;

public abstract class CreditProductService extends BankProductService {

    public boolean isEligibleForCreditProduct(Customer customer){
        return customer.isResident() && customer.getCreditScore() > 400;
    }

    public abstract CreditProduct applyCreditProduct(Customer customer) throws Exception;
}
