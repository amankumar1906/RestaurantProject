/**
 * Name: YOUR_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Handler.java
 * Description: Abstract Handler in the chain of responsibility pattern.
 */

package edu.bu.met.cs665.restaurant.ChainOfResponsibility;

/**
 * Handler interface for the chain of responsibility pattern.
 */
public abstract class Handler {

  protected Handler next;

  public void setNext(Handler next) {
    this.next = next;
  }

  public abstract void handleRequest(Request request);
}
