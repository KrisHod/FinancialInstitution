package com.go2it.entities;


public interface Promotionable {
    boolean isPromotionEligible(Customer customer);

    void applyPromotion(BankProduct product) throws Exception;

    int PROMOTION_ELIGIBLE_EXPENSES = 5000;
}
