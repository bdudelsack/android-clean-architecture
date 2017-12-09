package de.hs_flensburg.mobilecomputing.mvvm;

public class BankingService  {
    protected float balance = 0.0f;

    public float getBalance() {
        return balance;
    }

    public void modifyBalance(float value) {
        balance += value;
    }
}