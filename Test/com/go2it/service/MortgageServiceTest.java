package com.go2it.service;

import com.go2it.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MortgageServiceTest {
    @BeforeEach
    void setUp() {
        Customer customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
    }


    @Test
    void getRequestedAmountFromUser() {
    }

    @Test
    void applyCreditProduct() {
    }

    @Test
    void isPromotionEligible() {
    }

    @Test
    void applyPromotion() {
    }

    @Test
    void getMonthlyPayment() {
    }

    @Test
    void getTotalPayment() {
    }

    @Test
    void getMonthlyPaymentCalendar() {
    }
}