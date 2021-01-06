package com.go2it.service;

import com.go2it.entities.BankProduct;
import com.go2it.entities.Customer;

public interface Promotionable {
    boolean isPromotionEligible (Customer customer);
    void applyPromotion (Customer customer, BankProduct product) throws Exception;
}
