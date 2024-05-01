/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: FreeState.java
 * Description: This class represents a free state of a Table.
 */

package edu.bu.met.cs665.restaurant.state;

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
