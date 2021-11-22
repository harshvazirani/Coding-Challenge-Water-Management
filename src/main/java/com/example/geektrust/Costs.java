package com.example.geektrust;

public class Costs {
    public static final int BILL_DURATION = 30;
    public static final float CORP = 1;
    public static final float BOREWELL = 1.5f;
    public static final float TANKER_LIMIT1 = 500;
    public static final float TANKER_LIMIT2 = 1500;
    public static final float TANKER_LIMIT3 = 3000;
    public static final float TANKER_COST1 = 2;
    public static final float TANKER_COST2 = 3;
    public static final float TANKER_COST3 = 5;
    public static final float TANKER_COST4 = 8;
    private double totalConsumption;
    private double totalBill;

    public Costs(int baseConsumption, int corpRatio, int borewellRatio){
       totalConsumption = baseConsumption * BILL_DURATION;
       totalBill = (totalConsumption * corpRatio * CORP + totalConsumption * borewellRatio * BOREWELL);
       totalBill /= (corpRatio + borewellRatio);
    }

    public void guestCost(int guestConsumption){
        guestConsumption *= BILL_DURATION;
        totalConsumption += guestConsumption;
        if(guestConsumption <= TANKER_LIMIT1) {
            totalBill += guestConsumption * TANKER_COST1;
            return;
        }
        else {
            totalBill += TANKER_LIMIT1 * TANKER_COST1;
        }

        if (guestConsumption <= TANKER_LIMIT2) {
            totalBill += (guestConsumption - TANKER_LIMIT1) * TANKER_COST2;
            return;
        }
        else {
            totalBill += (TANKER_LIMIT2 - TANKER_LIMIT1) * TANKER_COST2;
        }

        if (guestConsumption <= TANKER_LIMIT3) {
            totalBill += (guestConsumption - TANKER_LIMIT2) * TANKER_COST3;
        }
        else {
            totalBill += (TANKER_LIMIT3 - TANKER_LIMIT2) * TANKER_COST3;
            totalBill += (guestConsumption - TANKER_LIMIT3) * TANKER_COST4;
        }
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
