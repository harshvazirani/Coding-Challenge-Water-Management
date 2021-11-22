package com.example.geektrust;

import java.io.File;
import java.lang.invoke.WrongMethodTypeException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File(args[0]));
        Apartment apartment;
        String[] command = scan.nextLine().split(" ");
        if (Objects.equals(command[0], "ALLOT_WATER")) {
            int bhk = Integer.parseInt(command[1]);
            String[] ratio = command[2].split(":");
            apartment = new Apartment(bhk, Integer.parseInt(ratio[0]), Integer.parseInt(ratio[1]));
        } else {throw new WrongMethodTypeException("First command should be 'ALLOT_WATER'");}

        while (scan.hasNextLine()) {
            command = scan.nextLine().split(" ");
            if (Objects.equals(command[0], "ADD_GUESTS")) {
                    apartment.addGuest(Integer.parseInt(command[1]));
            } else if (Objects.equals(command[0], "BILL")) {
                Bill bill = apartment.waterBill();
                System.out.println(bill.getConsumption() + " " + bill.getAmount());
            }
    }}
}