/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: PeakHourPricingStrategy.java
 * Description: Peak hour pricing strategy.
 */

package edu.bu.met.cs665.restaurant.Strategy;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * Peak hour pricing strategy.
 */
public class PeakHourPricingStrategy implements PricingStrategy {

  private static final double SURCHARGE = 1.2; // 20% surcharge

  @Override
  public double calculatePrice(FoodItem foodItem) {
    // Apply surcharge during peak hours
    return foodItem.getPrice() * SURCHARGE;
  }
}
