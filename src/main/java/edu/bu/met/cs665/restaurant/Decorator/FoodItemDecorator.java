/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: FoodItemDecorator.java
 * Description: Abstract decorator class for food items.
 */

package edu.bu.met.cs665.restaurant.Decorator;

import edu.bu.met.cs665.restaurant.common.FoodItem;
import java.util.List;

/**
 * Abstract class for decorating FoodItems.
 */
public abstract class FoodItemDecorator implements FoodItem {
  protected FoodItem decoratedFoodItem;

  public FoodItemDecorator(FoodItem decoratedFoodItem) {
    this.decoratedFoodItem = decoratedFoodItem;
  }

  @Override
  public String getName() {
    return decoratedFoodItem.getName();
  }

  @Override
  public double getPrice() {
    return decoratedFoodItem.getPrice();
  }

  @Override
  public List<String> getIngredients() {
    return decoratedFoodItem.getIngredients();
  }

  @Override
  public void setName(String name) {
    decoratedFoodItem.setName(name);
  }

  @Override
  public void setPrice(double price) {
    decoratedFoodItem.setPrice(price);
  }

  @Override
  public void addIngredient(String ingredient) {
    decoratedFoodItem.addIngredient(ingredient);
  }

  @Override
  public String getDescription() {
    return decoratedFoodItem.getDescription();
  }
}
