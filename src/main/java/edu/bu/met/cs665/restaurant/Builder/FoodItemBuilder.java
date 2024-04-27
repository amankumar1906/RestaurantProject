/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: FoodItemBuilder.java
 * Description: This interface defines the methods for building a food item.
 */

package edu.bu.met.cs665.restaurant.Builder;

import edu.bu.met.cs665.restaurant.common.FoodItem;

/**
 * This is the FoodItemBuilder interface.
 * This interface is responsible for declaring methods for building a food item.
 */
public interface FoodItemBuilder {
  FoodItemBuilder setName(String name);
  FoodItemBuilder setBasePrice(double price);
  FoodItemBuilder addIngredient(String ingredient);
  FoodItem build();
}
