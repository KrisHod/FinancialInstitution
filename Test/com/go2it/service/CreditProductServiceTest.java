package com.go2it.service;

import com.go2it.entities.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreditProductServiceTest {

    @Test
    void TestIfEligibleForCreditProductCustomerIsntResident() {
        Customer customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23),
                6000, 560, true);
        customer.setResident(false);
        assertFalse(CreditProductService.isEligibleForCreditProduct(customer));
    }

    @Test
    void TestIfEligibleForCreditProductCreditScoreNotEnough() {
        Customer customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        customer.setCreditScore(300);
        assertFalse(CreditProductService.isEligibleForCreditProduct(customer));
    }

    @Test
    void TestIfEligibleForCreditProduct() {
        Customer customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        assertTrue(CreditProductService.isEligibleForCreditProduct(customer));
    }
}