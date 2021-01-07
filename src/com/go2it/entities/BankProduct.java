package com.go2it.entities;

public abstract class BankProduct {
    private Customer customer;

    public BankProduct(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
