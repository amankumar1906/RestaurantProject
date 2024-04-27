/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: FreeState.java
 * Description: This class represents a free state of a Table.
 */

package edu.bu.met.cs665.restaurant.State;

/**
 * This is the FreeState class.
 * This class is responsible for representing a Table in a free state.
 */
public class FreeState implements TableState {

  /**
   * Handles the transition from free to occupied state.
   *
   * @param table the table whose state is to be handled
   */
  @Override
  public void handleRequest(Table table) {
    System.out.println("Table is now occupied.");
    table.setState(new OccupiedState());
  }
}
