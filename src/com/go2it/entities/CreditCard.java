package com.go2it.entities;

public class CreditCard extends CreditProduct{
    private String cardNumber;
    private String pin;
    private CreditLine creditLine;

    public CreditCard(String cardNumber, String pin, CreditLine creditLine) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.creditLine = creditLine;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public CreditLine getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(CreditLine creditLine) {
        this.creditLine = creditLine;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", creditLine=" + creditLine +
                '}';
    }
}
