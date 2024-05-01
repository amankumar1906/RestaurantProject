/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: TableState.java
 * Description: This interface defines the state of a Table.
 */

package edu.bu.met.cs665.restaurant.state;

/**
 * This is the TableState interface.
 * This interface is responsible for declaring methods to handle the state of a Table.
 */
public interface TableState {
  void handleRequest(Table table);
}
