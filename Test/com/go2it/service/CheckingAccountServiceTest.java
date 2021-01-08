package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.CheckingAccount;
import com.go2it.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountServiceTest {
    private CheckingAccountService checkingAccountService;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        checkingAccountService = new CheckingAccountService();

    }

    @Test
    void TestIfPromotionEligible() {
        assertTrue(checkingAccountService.isPromotionEligible(customer));
    }

    @Test
    void TestIfPromotionEligibleNotEnoughSpentLastMonth() {
        customer.setSpentLastMonth(3000);
        assertFalse(checkingAccountService.isPromotionEligible(customer));
    }


    @Test
    void applyPromotion() {

        try {
            checkingAccountService.applyPromotion(new CheckingAccount(customer, 10, 10));
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }
}