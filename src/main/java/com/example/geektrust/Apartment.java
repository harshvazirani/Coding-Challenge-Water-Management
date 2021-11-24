package com.example.geektrust;

public class Apartment {
    public static final int NUM_PEOPLE_2BHK = 3;
    public static final int NUM_PEOPLE_3BHK = 5;
    public static final int CONSUMPTION_PER_PERSON = 10;

    private final int bhk;
    private final int corpRatio;
    private final int borewellRatio;
    private int guests;
    private Costs costs;

    public Apartment(int n, int corporation, int borewell) throws Exception {
        if(n == 2 || n == 3){
            bhk = n;
            corpRatio = corporation;
            borewellRatio = borewell;
            guests = 0;
            baseConsumption();
        }
        else {
            throw new Exception("Please provide valid number of rooms.");
        }
    }

    public void addGuest(int n) {
        guests += n;
    }

    public Costs addGuestCost() {
        int guestConsumption = guests * CONSUMPTION_PER_PERSON;
        costs.guestCost(guestConsumption);
        return costs;
    }

    public Bill waterBill(){
        return new Bill(costs.getTotalConsumption(), costs.getTotalBill());
    }

    public void baseConsumption(){
        int baseConsumption;
        if(bhk == 2) {
            baseConsumption = NUM_PEOPLE_2BHK*CONSUMPTION_PER_PERSON;
        }

        else {
            baseConsumption = NUM_PEOPLE_3BHK*CONSUMPTION_PER_PERSON;
        }
        costs = new Costs(baseConsumption, corpRatio, borewellRatio);
    }

    public int getBhk() {
        return bhk;
    }

    public int getCorpRatio() {
        return corpRatio;
    }

    public int getBorewellRatio() {
        return borewellRatio;
    }

    public int getGuests() {
        return guests;
    }

    public Costs getCosts() {
        return costs;
    }
}
