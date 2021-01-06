package com.go2it.service;

import com.go2it.entities.*;

public class CreditLineService extends CreditProductService{


    @Override
    public boolean isPromotionEligible(Customer customer) {
        return false;
    }

    @Override
    public void applyPromotion(Customer customer, BankProduct product) throws Exception {

    }


    @Override
    public CreditLine applyCreditProduct(Customer customer) throws Exception {
        return null;
    }
}
