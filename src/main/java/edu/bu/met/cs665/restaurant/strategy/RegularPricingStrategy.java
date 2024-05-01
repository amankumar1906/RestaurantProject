/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: RegularPricingStrategy.java
 * Description: Regular pricing strategy.
 */

package edu.bu.met.cs665.restaurant.strategy;

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
