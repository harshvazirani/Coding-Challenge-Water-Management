package com.example.geektrust;

public class Bill {
    private int consumption;
    private int amount;
    public Bill(double consumption, double amount){
        this.consumption = (int)Math.ceil(consumption);
        this.amount = (int)Math.ceil(amount);
    }

    public int getConsumption() {
        return consumption;
    }

    public int getAmount() {
        return amount;
    }
}
