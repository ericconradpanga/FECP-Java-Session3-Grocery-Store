package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.example.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    HashMap<String, Integer> inventory;

    @BeforeEach
    void setup() {
        inventory = new HashMap<>();
        populateInventory(inventory);
    }

    @Test
    void shouldAddNewProductWithValidQuantity() {
        assertTrue(addProduct(inventory, "Banana", 30));
    }

    @Test
    void shouldAddNewProductWithZeroQuantity() {
        assertTrue(addProduct(inventory, "Mango", 0));
    }

    @Test
    void shouldNotAddExistingProduct() {
        assertFalse(addProduct(inventory, "Bread", 15));
    }

    @Test
    void shouldCheckForExistingProduct() {
        assertTrue(checkProduct(inventory, "Milk"));
    }

    @Test
    void shouldCheckForNonExistingProduct() {
        assertFalse(checkProduct(inventory, "Ice Cream"));
    }

    @Test
    void shouldUpdateExistingProductWithValidQuantity() {
        updateStock(inventory, "Bread", 25);
        int expected = 25;
        int actual = getQuantity(inventory, "Bread");
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotUpdateNonExistingProduct() {
        assertFalse(updateStock(inventory, "Tofu", 25));
    }

    @Test
    void shouldRemoveExistingProduct() {
        removeProduct(inventory, "Eggs");
        assertFalse(checkProduct(inventory, "Eggs"));
    }

    @Test
    void shouldNotRemoveNonExistingProduct() {
        assertFalse(removeProduct(inventory, "Pizza"));
    }
}