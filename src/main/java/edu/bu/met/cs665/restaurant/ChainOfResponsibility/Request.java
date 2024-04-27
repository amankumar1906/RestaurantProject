/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Request.java
 * Description: A request class for handlers to process.
 */

package edu.bu.met.cs665.restaurant.ChainOfResponsibility;

/**
 * Class for representing a request.
 */
public class Request {

  private String type; // e.g., "order", "bill", "cleaning"

  public Request(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
