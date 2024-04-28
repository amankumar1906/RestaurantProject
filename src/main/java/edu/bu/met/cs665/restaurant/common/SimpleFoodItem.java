/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: SimpleFoodItem.java
 * Description: Concrete implementation of the FoodItem interface.
 */

package edu.bu.met.cs665.restaurant.common;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the SimpleFoodItem class, a concrete implementation of FoodItem.
 */
public class SimpleFoodItem implements FoodItem {

  private String name;
  private double price;
  private final List<String> ingredients;
  private String description;

  public SimpleFoodItem() {
    this.ingredients = new ArrayList<>();
    this.description = "";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
    updateDescription();
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
    updateDescription();
  }

  @Override
  public List<String> getIngredients() {
    return ingredients;
  }

  @Override
  public void addIngredient(String ingredient) {
    this.ingredients.add(ingredient);
    updateDescription();
  }

  @Override
  public String getDescription() {
    return description;
  }

  private void updateDescription() {
    this.description = name + " with " + String.join(", ", ingredients) + " - $" + price;
  }
}
