/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Main class to simulate the restaurant operation with various design patterns.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.restaurant.Builder.ConcreteFoodItemBuilder;
import edu.bu.met.cs665.restaurant.ChainOfResponsibility.*;
import edu.bu.met.cs665.restaurant.State.FreeState;
import edu.bu.met.cs665.restaurant.State.OccupiedState;
import edu.bu.met.cs665.restaurant.Strategy.RegularPricingStrategy;
import edu.bu.met.cs665.restaurant.common.FoodItem;
import edu.bu.met.cs665.restaurant.Builder.FoodItemBuilder;
import edu.bu.met.cs665.restaurant.Decorator.WithExtraCheese;
import edu.bu.met.cs665.restaurant.Decorator.WithSauce;
import edu.bu.met.cs665.restaurant.State.Table;
import edu.bu.met.cs665.restaurant.Strategy.HappyHourPricingStrategy;
import edu.bu.met.cs665.restaurant.Strategy.PeakHourPricingStrategy;
import edu.bu.met.cs665.restaurant.Strategy.PricingStrategy;

import java.util.*;

/**
 * This is the Main class that simulates the restaurant operation.
 */
public class Main {

  private static final Scanner scanner = new Scanner(System.in);
  private static final Map<Integer, Table> tables = new HashMap<>();
  private static final int numberOfTables = 4; // Total number of tables available

  public static void main(String[] args) {
    initializeTables();

    while (true) {
      System.out.println("Enter 1 to add customers, 2 to process a bill, 0 to exit:");
      int action = scanner.nextInt();
      switch (action) {
        case 1:
          addCustomers();
          break;
        case 2:
          processBill();
          break;
        case 0:
          System.out.println("Exiting system.");
          scanner.close();
          return;
        default:
          System.out.println("Invalid input. Please try again.");
          break;
      }
    }
  }

  private static void initializeTables() {
    for (int i = 1; i <= numberOfTables; i++) {
      tables.put(i, new Table());
      System.out.println("Table " + i + " is initialized and free.");
    }
  }

  private static void addCustomers() {
    System.out.println("Available tables:");
    tables.forEach((number, table) -> {
      if (table.getState() instanceof FreeState) {
        System.out.println("Table " + number + " is free.");
      }
    });

    System.out.println("Enter the number of the table to reserve:");
    int tableNumber = scanner.nextInt();
    if (tableNumber > 0 && tableNumber <= numberOfTables && tables.get(tableNumber).getState() instanceof FreeState) {
      tables.get(tableNumber).requestState();
      System.out.println("Table " + tableNumber + " is now reserved.");
    } else {
      System.out.println("Invalid selection or table not free.");
    }
  }

  private static void processBill() {
    System.out.println("Occupied tables:");
    tables.forEach((number, table) -> {
      if (table.getState() instanceof OccupiedState) {
        System.out.println("Table " + number + " is occupied.");
      }
    });

    System.out.println("Enter the number of the table to bill (enter 0 to go back):");
    int tableNumber = scanner.nextInt();
    if (tableNumber == 0) {
      return;
    }

    if (tableNumber > 0 && tableNumber <= numberOfTables && tables.get(tableNumber).getState() instanceof OccupiedState) {
      FoodItem orderedItem = takeOrder();
      PricingStrategy strategy = selectPricingStrategy();
      double price = strategy.calculatePrice(orderedItem);
      System.out.printf("Total price for %s at Table %d: $%.2f\n", orderedItem.getDescription(), tableNumber, price);

      // Create handlers
      Handler orderHandler = new OrderHandler();
      Handler billHandler = new BillHandler();
      Handler cleaningHandler = new CleaningHandler();

      orderHandler.setNext(billHandler);
      billHandler.setNext(cleaningHandler);

      // Handle requests
      Request orderRequest = new Request("order");
      Request billRequest = new Request("bill");
      Request cleaningRequest = new Request("cleaning");

      orderHandler.handleRequest(orderRequest);
      orderHandler.handleRequest(billRequest);
      orderHandler.handleRequest(cleaningRequest);

      tables.get(tableNumber).requestState(); // Change state back to free after billing
      System.out.println("Table " + tableNumber + " is now free.");
    } else {
      System.out.println("Invalid selection or table not occupied.");
    }
  }

  private static FoodItem takeOrder() {
    System.out.println("Building your food item. Please enter the base food (Pizza, Burger, Salad):");
    scanner.nextLine(); // clear buffer
    String baseFood = scanner.nextLine();

    FoodItemBuilder builder = new ConcreteFoodItemBuilder();
    FoodItem item = builder.setName(baseFood)
        .setBasePrice(10.0) // Simple flat rate for example purposes
        .build();

    System.out.println("Would you like to add extra cheese? (yes/no)");
    if (scanner.nextLine().equalsIgnoreCase("yes")) {
      item = new WithExtraCheese(item);
    }

    System.out.println("Would you like to add extra sauce? (yes/no)");
    if (scanner.nextLine().equalsIgnoreCase("yes")) {
      item = new WithSauce(item);
    }

    return item;
  }

  private static PricingStrategy selectPricingStrategy() {
    System.out.println("Select business hour: 1 for Happy Hour, 2 for Peak Hour, 3 for Regular");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        return new HappyHourPricingStrategy();
      case 2:
        return new PeakHourPricingStrategy();
      default:
        return new RegularPricingStrategy();
    }
  }
}