/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: WithSauce.java
 * Description: Adds sauce to the food item.
 */

package edu.bu.met.cs665.restaurant.Decorator;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * Decorator that adds sauce to a food item.
 */
public class WithSauce extends FoodItemDecorator {

  public WithSauce(FoodItem decoratedFoodItem) {
    super(decoratedFoodItem);
  }

  @Override
  public String getDescription() {
    return super.getDescription() + ", with sauce";
  }

  @Override
  public double getPrice() {
    return super.getPrice() + 0.75;
  }
}
