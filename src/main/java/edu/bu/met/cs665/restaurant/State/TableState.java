/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: TableState.java
 * Description: This interface defines the state of a Table.
 */

package edu.bu.met.cs665.restaurant.State;

/**
 * This is the TableState interface.
 * This interface is responsible for declaring methods to handle the state of a Table.
 */
public interface TableState {
  void handleRequest(Table table);
}
