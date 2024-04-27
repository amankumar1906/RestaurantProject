/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: ConcreteFoodItemBuilder.java
 * Description: This class is a concrete builder for creating food items.
 */

package edu.bu.met.cs665.restaurant.Builder;

import edu.bu.met.cs665.restaurant.common.FoodItem;
import edu.bu.met.cs665.restaurant.common.SimpleFoodItem;

/**
 * This is the ConcreteFoodItemBuilder class.
 * This class is responsible for providing the concrete implementation for building food items.
 */
public class ConcreteFoodItemBuilder implements FoodItemBuilder {

  private final FoodItem foodItem;

  public ConcreteFoodItemBuilder() {
    foodItem = new SimpleFoodItem();  // Use the concrete class
  }

  @Override
  public FoodItemBuilder setName(String name) {
    foodItem.setName(name);
    return this;
  }

  @Override
  public FoodItemBuilder setBasePrice(double price) {
    foodItem.setPrice(price);
    return this;
  }

  @Override
  public FoodItemBuilder addIngredient(String ingredient) {
    foodItem.addIngredient(ingredient);
    return this;
  }

  @Override
  public FoodItem build() {
    return foodItem;
  }
}
