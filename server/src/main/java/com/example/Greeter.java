package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
   * 
   * @param String someone A generic name
   * @return String someone A generic greeting with someone's name
   */
  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
