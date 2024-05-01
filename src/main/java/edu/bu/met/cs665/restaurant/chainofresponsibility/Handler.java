/**
 * Name: Aman Kumar
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: Handler.java
 * Description: Abstract Handler in the chain of responsibility pattern.
 */

package edu.bu.met.cs665.restaurant.chainofresponsibility;

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
