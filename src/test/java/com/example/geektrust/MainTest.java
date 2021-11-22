package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    Apartment apartment;

    @Test
    @DisplayName("Testing Apartment Class Directly")
    void testcase() throws Exception {
        apartment = new Apartment(3, 5, 4);
        apartment.addGuest(3);
        apartment.addGuest(5);
        Bill bill = apartment.waterBill();
        assertEquals(3900, bill.getConsumption());
        assertEquals(10334, bill.getAmount());
    }

    @Test
    @DisplayName("Testing Apartment Class Directly")
    void testcaseTwo() throws Exception {
        apartment = new Apartment(2, 1, 2);
        Bill bill = apartment.waterBill();
        assertEquals(900, bill.getConsumption());
        assertEquals(1200, bill.getAmount());
    }

    @Test
    @DisplayName("Testing Apartment Class Directly")
    void testcaseThree() throws Exception {
        apartment = new Apartment(2, 5, 1);
        apartment.addGuest(7);
        apartment.addGuest(4);
        apartment.addGuest(4);
        Bill bill = apartment.waterBill();
        assertEquals(5400, bill.getConsumption());
        assertEquals(24475, bill.getAmount());
    }

    @Test
    @DisplayName("Testing Apartment Class Directly")
    void testcaseFour() throws Exception {
        apartment = new Apartment(2, 1, 2);
        apartment.addGuest(5);
        Bill bill = apartment.waterBill();
        assertEquals(2400, bill.getConsumption());
        assertEquals(5200, bill.getAmount());
    }

    @Test
    @DisplayName("Exception Testing")
    void shouldThrowExceptionWhen5BHKApartmentIsInitialized() {
        Throwable exception = assertThrows(Exception.class, () -> new Apartment(5, 1, 2));
        assertEquals("Please provide valid number of rooms.", exception.getMessage());
    }

/*    @Test
    @DisplayName("Testing Main Class")
    void testmain() throws Exception {
        String filepath = ".\\sample_input\\input1.txt";
        int[] arr = Main.waterManagement(filepath);
        assertEquals(3900, arr[0]);
        assertEquals(10334, arr[1]);
    }*/
}
