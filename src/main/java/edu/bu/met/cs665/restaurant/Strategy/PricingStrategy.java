/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: PricingStrategy.java
 * Description: Interface for different pricing strategies based on business hours.
 */

package edu.bu.met.cs665.restaurant.Strategy;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * Interface for pricing strategies.
 */
public interface PricingStrategy {
  double calculatePrice(FoodItem foodItem);
}
