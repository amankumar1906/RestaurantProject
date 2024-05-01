/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: PeakHourPricingStrategy.java
 * Description: Peak hour pricing strategy.
 */

package edu.bu.met.cs665.restaurant.strategy;

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
