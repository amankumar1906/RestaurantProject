/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: BillHandler.java
 * Description: Handler for billing requests.
 */

package edu.bu.met.cs665.restaurant.chainofresponsibility;

/**
 * Handler for billing requests.
 */
public class BillHandler extends Handler {

  @Override
  public void handleRequest(Request request) {
    if (request.getType().equals("bill")) {
      System.out.println("Billing request is being processed.");
      // Logic for handling billing
    } else if (next != null) {
      next.handleRequest(request);
    }
  }
}
