/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: OrderHandler.java
 * Description: Handler for order requests.
 */

package edu.bu.met.cs665.restaurant.chainofresponsibility;

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
