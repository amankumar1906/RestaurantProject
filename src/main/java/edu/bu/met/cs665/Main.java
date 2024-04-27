/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Main class to simulate the restaurant operation with various design patterns.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.restaurant.Builder.ConcreteFoodItemBuilder;
import edu.bu.met.cs665.restaurant.common.FoodItem;
import edu.bu.met.cs665.restaurant.Builder.FoodItemBuilder;
import edu.bu.met.cs665.restaurant.ChainOfResponsibility.*;
import edu.bu.met.cs665.restaurant.Decorator.WithExtraCheese;
import edu.bu.met.cs665.restaurant.Decorator.WithSauce;
import edu.bu.met.cs665.restaurant.State.Table;
import edu.bu.met.cs665.restaurant.Strategy.HappyHourPricingStrategy;
import edu.bu.met.cs665.restaurant.Strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Main class that simulates the restaurant operation.
 */
public class Main {

  public static void main(String[] args) {

    // Initialize tables in free state
    List<Table> tables = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      tables.add(new Table());
    }

    // Customer arrives and we assign the first free table
    Table table1 = tables.get(0);
    table1.requestState(); // Changes state from Free to Occupied

    // Build a food item
    FoodItemBuilder builder = new ConcreteFoodItemBuilder();
    FoodItem pizza = builder.setName("Pizza")
        .setBasePrice(10.0)
        .addIngredient("Cheese")
        .addIngredient("Tomato")
        .build();

    // Decorate the food item
    FoodItem decoratedPizza = new WithExtraCheese(new WithSauce(pizza));

    // Assume we are in Happy Hour and set pricing strategy
    PricingStrategy pricingStrategy = new HappyHourPricingStrategy();

    // Calculate the price for the decorated food item
    double price = pricingStrategy.calculatePrice(decoratedPizza);
    System.out.println("The price of the decorated pizza during Happy Hour is: $" + price);

    // Create a chain for handling requests
    Handler orderHandler = new OrderHandler();
    Handler billHandler = new BillHandler();
    Handler cleaningHandler = new CleaningHandler();

    // Set the chain of handlers
    orderHandler.setNext(billHandler);
    billHandler.setNext(cleaningHandler);

    // Create and process an order request
    Request orderRequest = new Request("order");
    orderHandler.handleRequest(orderRequest);

    // Customer asks for the bill
    Request billRequest = new Request("bill");
    orderHandler.handleRequest(billRequest);

    // Once customers leave, table needs cleaning
    Request cleaningRequest = new Request("cleaning");
    orderHandler.handleRequest(cleaningRequest);

    // Change the table state back to free
    table1.requestState(); // Changes state from Occupied to Free

    System.out.println("Simulation completed.");
  }
}
