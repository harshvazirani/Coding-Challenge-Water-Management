package com.example.geektrust;

import java.io.File;
import java.lang.invoke.WrongMethodTypeException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String filepath = args[0];
        File file = new File(filepath);
        Scanner scan = new Scanner(file);

        String[] command;
        Apartment apartment;
        command = scan.nextLine().split(" ");
        if (Objects.equals(command[0], "ALLOT_WATER")) {
            int bhk = Integer.parseInt(command[1]);
            String[] ratio = command[2].split(":");
            int corp = Integer.parseInt(ratio[0]);
            int borewell = Integer.parseInt(ratio[1]);
            apartment = new Apartment(bhk, corp, borewell);
        } else {
            throw new WrongMethodTypeException("First command should be 'ALLOT_WATER'");
        }
        while (scan.hasNextLine()) {
            command = scan.nextLine().split(" ");
            if (Objects.equals(command[0], "ADD_GUESTS")) {
                try {
                    apartment.addGuest(Integer.parseInt(command[1]));
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (Objects.equals(command[0], "BILL")) {
                Bill bill = apartment.waterBill();
                System.out.println(bill.getConsumption() + " " + bill.getAmount());
            } else {
                throw new WrongMethodTypeException("UNKNOWN COMMAND IN INPUT FILE");
            }
        }
    }

}