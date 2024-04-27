/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: BillHandler.java
 * Description: Handler for billing requests.
 */

package edu.bu.met.cs665.restaurant.ChainOfResponsibility;

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
