/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Table.java
 * Description: This class is responsible for managing the state of a table.
 */

package edu.bu.met.cs665.restaurant.State;

/**
 * This is the Table class.
 * This class is responsible for representing and managing a table's state.
 */
public class Table {

  private TableState state;

  public Table() {
    // Tables are initially free
    this.state = new FreeState();
  }

  /**
   * Sets the state of the table.
   *
   * @param state the new state of the table
   */
  public void setState(TableState state) {
    this.state = state;
  }

  /**
   * Requests the handling of the current state.
   */
  public void requestState() {
    this.state.handleRequest(this);
  }
}