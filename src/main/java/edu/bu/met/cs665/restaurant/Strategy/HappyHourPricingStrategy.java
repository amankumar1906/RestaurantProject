/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: HappyHourPricingStrategy.java
 * Description: Happy hour pricing strategy.
 */

package edu.bu.met.cs665.restaurant.Strategy;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * Happy hour pricing strategy.
 */
public class HappyHourPricingStrategy implements PricingStrategy {

  private static final double DISCOUNT = 0.8; // 20% discount

  @Override
  public double calculatePrice(FoodItem foodItem) {
    // Apply discount during happy hour
    return foodItem.getPrice() * DISCOUNT;
  }
}
