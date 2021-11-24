package com.example.geektrust;

import java.io.File;
import java.lang.invoke.WrongMethodTypeException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static Apartment apartment;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File(args[0]));

        String[] command = scan.nextLine().split(" ");

        allotWater(command);

        while (scan.hasNextLine()) {
            command = scan.nextLine().split(" ");
            if (Objects.equals(command[0], "ADD_GUESTS")) {
                    addGuests(command);
            } else if (Objects.equals(command[0], "BILL")) {
                    printBill();
            }
    }}

    public static Apartment allotWater(String[] command) throws Exception {
        if (Objects.equals(command[0], "ALLOT_WATER")) {
            int bhk = Integer.parseInt(command[1]);
            String[] ratio = command[2].split(":");
            int corporation = Integer.parseInt(ratio[0]);
            int borewell = Integer.parseInt(ratio[1]);
            apartment = new Apartment(bhk, corporation, borewell);
        } else {throw new Exception("First command should be 'ALLOT_WATER'");}
        return apartment;
    }

    public static Apartment addGuests(String[] command) {
        apartment.addGuest(Integer.parseInt(command[1]));
        return apartment;
    }

    public static Bill printBill(){
        apartment.addGuestCost();
        Bill bill = apartment.waterBill();
        System.out.println(bill.getConsumption() + " " + bill.getAmount());
        return bill;
    }
}