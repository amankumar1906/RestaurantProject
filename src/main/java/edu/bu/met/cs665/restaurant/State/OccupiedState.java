/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: OccupiedState.java
 * Description: This class represents an occupied state of a Table.
 */

package edu.bu.met.cs665.restaurant.State;

/**
 * This is the OccupiedState class.
 * This class is responsible for representing a Table in an occupied state.
 */
public class OccupiedState implements TableState {

  /**
   * Handles the transition from occupied to free state.
   *
   * @param table the table whose state is to be handled
   */
  @Override
  public void handleRequest(Table table) {
    System.out.println("Table is now free.");
    table.setState(new FreeState());
  }
}
