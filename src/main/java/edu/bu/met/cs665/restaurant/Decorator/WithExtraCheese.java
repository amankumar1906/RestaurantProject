/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: WithExtraCheese.java
 * Description: Adds extra cheese to the food item.
 */

package edu.bu.met.cs665.restaurant.Decorator;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * Decorator that adds extra cheese to a food item.
 */
public class WithExtraCheese extends FoodItemDecorator {

  public WithExtraCheese(FoodItem decoratedFoodItem) {
    super(decoratedFoodItem);
  }

  @Override
  public String getDescription() {
    return super.getDescription() + ", extra cheese";
  }

  @Override
  public double getPrice() {
    return super.getPrice() + 1.50;
  }
}
