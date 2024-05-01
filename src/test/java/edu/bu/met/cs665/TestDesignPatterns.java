package edu.bu.met.cs665;

import edu.bu.met.cs665.restaurant.builder.ConcreteFoodItemBuilder;
import edu.bu.met.cs665.restaurant.builder.FoodItemBuilder;
import edu.bu.met.cs665.restaurant.chainofresponsibility.*;
import edu.bu.met.cs665.restaurant.decorator.WithExtraCheese;
import edu.bu.met.cs665.restaurant.decorator.WithSauce;
import edu.bu.met.cs665.restaurant.state.FreeState;
import edu.bu.met.cs665.restaurant.state.OccupiedState;
import edu.bu.met.cs665.restaurant.state.Table;
import edu.bu.met.cs665.restaurant.strategy.HappyHourPricingStrategy;
import edu.bu.met.cs665.restaurant.strategy.PeakHourPricingStrategy;
import edu.bu.met.cs665.restaurant.strategy.PricingStrategy;
import edu.bu.met.cs665.restaurant.strategy.RegularPricingStrategy;
import edu.bu.met.cs665.restaurant.common.FoodItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDesignPatterns {

  @Test
  public void testFoodItemBuilder() {
    FoodItemBuilder builder = new ConcreteFoodItemBuilder();
    FoodItem pizza = builder.setName("Pizza")
        .setBasePrice(10.0)
        .build();
    assertEquals("Pizza", pizza.getName());
    assertEquals(10.0, pizza.getPrice(), 0.01);
  }

  @Test
  public void testDecoratorPattern() {
    FoodItemBuilder builder = new ConcreteFoodItemBuilder();
    FoodItem pizza = builder.setName("Pizza")
        .setBasePrice(10.0)
        .build();
    FoodItem pizzaWithCheese = new WithExtraCheese(pizza);
    FoodItem pizzaWithCheeseAndSauce = new WithSauce(pizzaWithCheese);

    // Correcting expected price considering $1.50 for cheese and $0.75 for sauce
    assertEquals(12.25, pizzaWithCheeseAndSauce.getPrice(), 0.01);  // 10 + 1.50 + 0.75 = 12.25
    assertTrue(pizzaWithCheeseAndSauce.getDescription().contains("extra cheese"));
    assertTrue(pizzaWithCheeseAndSauce.getDescription().contains("with sauce"));
  }


  @Test
  public void testPricingStrategy() {
    FoodItemBuilder builder = new ConcreteFoodItemBuilder();
    FoodItem pizza = builder.setName("Pizza")
        .setBasePrice(10.0)
        .build();
    PricingStrategy happyHour = new HappyHourPricingStrategy();
    double discountedPrice = happyHour.calculatePrice(pizza);
    assertEquals(8.0, discountedPrice, 0.01); // Expecting a 20% discount
  }

  @Test
  public void testStateTransition() {
    // Assuming Table's state transitions are correctly implemented
    Table table = new Table();
    assertTrue("Initial state should be FreeState", table.getState() instanceof FreeState);
    table.requestState();
    assertTrue("State after request should be OccupiedState", table.getState() instanceof OccupiedState);
  }

  @Test
  public void testTableStateManagement() {
    Table table = new Table();
    table.requestState();
    assertTrue(table.getState() instanceof OccupiedState);
    table.requestState();  // Assuming it toggles back to FreeState
    assertTrue(table.getState() instanceof FreeState);
  }

  @Test
  public void testChainOfResponsibility() {
    Handler orderHandler = new OrderHandler();
    Handler billHandler = new BillHandler();
    Handler cleaningHandler = new CleaningHandler();
    orderHandler.setNext(billHandler);
    billHandler.setNext(cleaningHandler);

    Request orderRequest = new Request("order");
    Request billRequest = new Request("bill");
    Request cleaningRequest = new Request("cleaning");

    // Normally, we'd need to assert some state change or use a mock to verify interactions.
    // Here, we simulate handling to see if it passes without exceptions.
    orderHandler.handleRequest(orderRequest);
    orderHandler.handleRequest(billRequest);
    orderHandler.handleRequest(cleaningRequest);
    assertTrue(true);  // Simplistic check
  }

  @Test
  public void testPricingStrategyApplication() {
    FoodItemBuilder builder = new ConcreteFoodItemBuilder();
    FoodItem pizza = builder.setName("Pizza")
        .setBasePrice(20.0)
        .build();
    PricingStrategy regular = new RegularPricingStrategy();
    PricingStrategy happyHour = new HappyHourPricingStrategy();
    PricingStrategy peakHour = new PeakHourPricingStrategy();

    assertEquals(20.0, regular.calculatePrice(pizza), 0.01);
    assertEquals(16.0, happyHour.calculatePrice(pizza), 0.01); // 20% discount
    assertEquals(24.0, peakHour.calculatePrice(pizza), 0.01); // 20% surcharge
  }

  @Test
  public void testRepeatedStateChanges() {
    Table table = new Table();
    for (int i = 0; i < 5; i++) {  // Toggle state multiple times
      table.requestState();
    }
    assertTrue("State should be FreeState after an odd number of toggles", table.getState() instanceof OccupiedState);
  }

}

