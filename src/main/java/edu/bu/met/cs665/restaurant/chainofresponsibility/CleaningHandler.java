/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: CleaningHandler.java
 * Description: Handler for cleaning requests.
 */

package edu.bu.met.cs665.restaurant.chainofresponsibility;

/**
 * Handler for cleaning requests.
 */
public class CleaningHandler extends Handler {

  @Override
  public void handleRequest(Request request) {
    if (request.getType().equals("cleaning")) {
      System.out.println("Cleaning request is being processed.");
      // Logic for handling table cleaning
    } else if (next != null) {
      next.handleRequest(request);
    }
  }
}
