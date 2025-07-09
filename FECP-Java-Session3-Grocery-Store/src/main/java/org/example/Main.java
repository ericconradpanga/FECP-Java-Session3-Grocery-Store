package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        populateInventory(inventory);

        String productName;
        int quantity;

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
                    System.out.print("Enter product name: ");
                    productName = scanner.next();

                    System.out.print("Enter quantity: ");
                    quantity = scanner.nextInt();

                    addProduct(inventory, productName, quantity);
                    break;
                case 3:
                    System.out.print("Enter product name to check: ");
                    productName = scanner.next();

                    checkProduct(inventory, productName);
                    break;
                case 4:
                    System.out.print("Enter product name to update: ");
                    productName = scanner.next();

                    System.out.print("Enter new stock to quantity: ");
                    quantity = scanner.nextInt();

                    updateStock(inventory, productName, quantity);
                    break;
                case 5:
                    System.out.print("Enter product name to remove: ");
                    productName = scanner.next();

                    removeProduct(inventory, productName);
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
    public static void populateInventory(HashMap<String, Integer> inventory) {
        inventory.put("Milk", 20);
        inventory.put("Bread", 15);
        inventory.put("Eggs", 30);
    }

    // method to print the menu
    public static void displayMenu() {
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
    public static boolean inventoryIsEmpty(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.\n");
            return true;
        } else return false;
    }

    // method to print the inventory's contents
    public static void viewInventory(HashMap<String, Integer> inventory) {
        if (inventoryIsEmpty(inventory)) { return; } // inventory should not be empty

        System.out.println("\nCurrent Inventory:");

        // iterate through each entry and print their respective key and value
        for (HashMap.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println();
    }

    // method to add a product to the inventory
    public static boolean addProduct(HashMap<String, Integer> inventory, String productName, int quantity) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        if (quantity < 0) { // quantity should not be negative
            System.out.println("Invalid quantity.");
            return false;
        }

        if (inventory.containsKey(productName)) {
            System.out.println(productName + " already exists in inventory.");
            return false;
        } else {
            inventory.put(productName, quantity);
            System.out.println("Product added!\n"); // add the product to the inventory
            return true;
        }
    }

    // method to check if a product exists in the inventory
    public static boolean checkProduct(HashMap<String, Integer> inventory, String productToCheck) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        // check if key exists
        if (inventory.containsKey(productToCheck)) {
            System.out.println(productToCheck + " is in stock: " + inventory.get(productToCheck) + "\n");
            return true;
        } else {
            System.out.println(productToCheck + " not found in inventory.\n");
            return false;
        }
    }

    // method to update the stock of a product
    public static boolean updateStock(HashMap<String, Integer> inventory, String productName, int newQuantity) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        // check if key exists
        if (inventory.containsKey(productName)) {
            // new quantity should not be negative
            if (newQuantity < 0) {
                System.out.println("Invalid quantity.");
                return false;
            }

            inventory.put(productName, newQuantity); // update the stock of the product
            System.out.println("Stock updated!\n");
            return true;
        } else {
            System.out.println(productName + " not found in inventory.\n");
            return false;
        }
    }

    // method to remove a product from the inventory
    public static boolean removeProduct(HashMap<String, Integer> inventory, String productToRemove) {
        if (inventoryIsEmpty(inventory)) { return false; } // inventory should not be empty

        // check if key exists
        if (inventory.containsKey(productToRemove)) {
            inventory.remove(productToRemove); // remove the product from the inventory
            System.out.println("Product removed.\n");
            return true;
        } else {
            System.out.println(productToRemove + " not found in inventory.\n");
            return false;
        }
    }

    // method to retrieve the quantity of an existing product
    public static int getQuantity(HashMap<String, Integer> inventory, String productName) {
        if (inventoryIsEmpty(inventory)) { return -1; } // inventory should not be empty

        // check if key exists
        if (inventory.containsKey(productName)) {
            return inventory.get(productName);
        } else {
            System.out.println(productName + " not found in inventory.\n");
            return -1;
        }
    }
}