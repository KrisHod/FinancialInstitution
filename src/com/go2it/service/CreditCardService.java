package com.go2it.service;

import com.go2it.entities.BankProduct;
import com.go2it.entities.CreditCard;
import com.go2it.entities.Customer;


public class CreditCardService extends CreditProductService {


    @Override
    public boolean isPromotionEligible(Customer customer) {
        return false;
    }

    @Override
    public void applyPromotion(Customer customer, BankProduct product) throws Exception {

    }


    @Override
    public CreditCard applyCreditProduct(Customer customer) throws Exception {
        return null;
    }
}
