/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: FoodItem.java
 * Description: Interface for food items that can be built and decorated.
 */

package edu.bu.met.cs665.restaurant.common;

import java.util.List;

/**
 * Interface for food items.
 */
public interface FoodItem {
  String getName();

  double getPrice();

  List<String> getIngredients();

  void setName(String name);

  void setPrice(double price);

  void addIngredient(String ingredient);

  String getDescription();
}
