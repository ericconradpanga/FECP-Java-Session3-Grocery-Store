package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        populateInventory(inventory);

        int choice = 0;
        while (choice != 6) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    viewInventory(inventory);
                    break;
                case 2:
                    addProduct(inventory, scanner);
                    break;
                case 3:
                    checkProduct(inventory, scanner);
                    break;
                case 4:
                    updateStock(inventory, scanner);
                    break;
                case 5:
                    removeProduct(inventory, scanner);
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }

    // method to populate the inventory with initial data
    private static void populateInventory(HashMap<String, Integer> inventory) {
        inventory.put("Milk", 20);
        inventory.put("Bread", 15);
        inventory.put("Eggs", 30);
    }

    // method to print the menu
    private static void displayMenu() {
        System.out.println("--- Grocery Inventory Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Stock");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    // method to check if the inventory is empty
    private static boolean inventoryIsEmpty(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.\n");
            return true;
        } else return false;
    }

    // method to print the inventory's contents
    private static boolean viewInventory(HashMap<String, Integer> inventory) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        System.out.println("\nCurrent Inventory:");

        // iterate through each entry and print their respective key and value
        for (HashMap.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println();
        return true;
    }

    // method to add a product to the inventory
    private static boolean addProduct(HashMap<String, Integer> inventory, Scanner scanner) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        System.out.print("Enter product name: ");
        String productName = scanner.next();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (quantity < 0) { // quantity should not be negative
            System.out.println("Invalid quantity.");
            return false;
        }

        inventory.put(productName, quantity);
        System.out.println("Product added!\n"); // add the product to the inventory
        return true;
    }

    // method to check if a product exists in the inventory
    private static boolean checkProduct(HashMap<String, Integer> inventory, Scanner scanner) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        System.out.print("Enter product name to check: ");
        String productName = scanner.next();

        // check if key exists
        if (inventory.containsKey(productName)) {
            System.out.println(productName + " is in stock: " + inventory.get(productName) + "\n");
            return true;
        } else {
            System.out.println("Product not found in inventory.\n");
            return false;
        }
    }

    // method to update the stock of a product
    private static boolean updateStock(HashMap<String, Integer> inventory, Scanner scanner) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        System.out.print("Enter product name to update: ");
        String productName = scanner.next();

        // check if key exists
        if (inventory.containsKey(productName)) {
            System.out.print("Enter new stock to quantity: ");
            int newQuantity = scanner.nextInt();

            // new quantity should not be negative
            if (newQuantity < 0) {
                System.out.println("Invalid quantity.");
                return false;
            }

            inventory.put(productName, newQuantity); // update the stock of the product
            System.out.println("Stock updated!\n");
            return true;
        } else {
            System.out.println("Product not found in inventory.\n");
            return false;
        }
    }

    // method to remove a product from the inventory
    private static boolean removeProduct(HashMap<String, Integer> inventory, Scanner scanner) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        System.out.print("Enter product name to remove: ");
        String productName = scanner.next();

        // check if key exists
        if (inventory.containsKey(productName)) {
            inventory.remove(productName); // remove the product from the inventory
            System.out.println("Product removed.\n");
            return true;
        } else {
            System.out.println("Product not found in inventory.\n");
            return false;
        }
    }
}