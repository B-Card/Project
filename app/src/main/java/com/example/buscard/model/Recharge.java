package com.example.buscard;

public class Recharge {

    String cardNumber, currentBalance;

    public Recharge() {
    }

    public Recharge(String cardNumber, String currentBalance) {
        this.cardNumber = cardNumber;
        this.currentBalance = currentBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
}
