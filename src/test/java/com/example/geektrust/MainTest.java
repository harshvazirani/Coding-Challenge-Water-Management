package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    @DisplayName("APARTMENT EXCEPTION TEST")
    void shouldThrowExceptionWhen5BHKApartmentIsInititalized() throws Exception {
        assertThrows(Exception.class, () -> new Apartment(5, 1 , 1));
    }

    @Test
    @DisplayName("ALLOT_WATER TEST")
    void allotWaterTest() throws Exception {
        String[] command = {"ALLOT_WATER","2", "1:2"};
        Apartment apartment = Main.allotWater(command);
        assertEquals(2, apartment.getBhk());
        assertEquals(1, apartment.getCorpRatio());
        assertEquals(2, apartment.getBorewellRatio());
        assertEquals(0, apartment.getGuests());
        Costs costs = apartment.getCosts();
        assertEquals(900, costs.getTotalConsumption());
        assertEquals(1200, costs.getTotalBill());
    }

    @Test
    @DisplayName("ALLOT_WATER EXCEPTION TEST")
    void allotWaterShouldThrowExceptionIfCommandIsInvalid() throws Exception {
        String[] command = {"ALLOT","2", "1:2"};
        assertThrows(Exception.class, () -> Main.allotWater(command));
    }

    @Test
    @DisplayName("ADD_GUESTS TEST")
    void addGuestsTest() throws Exception {
        String[] command = {"ALLOT_WATER","2", "1:2"};
        Main.allotWater(command);
        command = new String[]{"ADD_GUESTS", "2"};
        Apartment apartment = Main.addGuests(command);
        assertEquals(2, apartment.getGuests());
    }

    @Test
    @DisplayName("BILL TEST")
    void billTest() throws Exception {
        String[] command = {"ALLOT_WATER","2", "1:2"};
        Main.allotWater(command);
        command = new String[]{"ADD_GUESTS", "2"};
        Main.addGuests(command);
        Bill bill = Main.printBill();
        assertEquals(2500, bill.getAmount());
        assertEquals(1500, bill.getConsumption());
    }

    @Test
    @DisplayName("COSTS TEST")
    void costsTest() throws Exception {
        String[] command = {"ALLOT_WATER","2", "1:2"};
        Main.allotWater(command);
        command = new String[]{"ADD_GUESTS", "10"};
        Apartment apartment = Main.addGuests(command);
        Costs costs = apartment.addGuestCost();
        assertEquals(12700, costs.getTotalBill());
        assertEquals(3900, costs.getTotalConsumption());
    }

    @Test
    @DisplayName("COSTS TEST 2")
    void costsTest2() throws Exception {
        String[] command = {"ALLOT_WATER","2", "1:2"};
        Main.allotWater(command);
        command = new String[]{"ADD_GUESTS", "15"};
        Apartment apartment = Main.addGuests(command);
        Costs costs = apartment.addGuestCost();
        assertEquals(24700, costs.getTotalBill());
        assertEquals(5400, costs.getTotalConsumption());
    }

}

