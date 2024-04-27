/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: RegularPricingStrategy.java
 * Description: Regular pricing strategy.
 */

package edu.bu.met.cs665.restaurant.Strategy;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * Regular pricing strategy.
 */
public class RegularPricingStrategy implements PricingStrategy {

  @Override
  public double calculatePrice(FoodItem foodItem) {
    // No discount or surcharge during regular hours
    return foodItem.getPrice();
  }
}
