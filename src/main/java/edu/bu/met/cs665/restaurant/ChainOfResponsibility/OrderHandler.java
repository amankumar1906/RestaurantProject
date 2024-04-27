/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: OrderHandler.java
 * Description: Handler for order requests.
 */

package edu.bu.met.cs665.restaurant.ChainOfResponsibility;

/**
 * Handler for order requests.
 */
public class OrderHandler extends Handler {

  @Override
  public void handleRequest(Request request) {
    if (request.getType().equals("order")) {
      System.out.println("Order has been taken and is being processed.");
      // Logic for handling order
    } else if (next != null) {
      next.handleRequest(request);
    }
  }
}
