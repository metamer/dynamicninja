package com.screen;

/**
 * Screen class for printing out on a standard 80x24 terminal
 * 
 * @author Matt
 * 
 */
public class Screen {

  private String emptyLine = "012345678901234567890123456789"
      + "01234567890123456789012345678901234567890123456789";

  public void resetTerminal() {
    for (int i = 0; i < 24; i++) {
      System.out.println(emptyLine);
    }
  }

}
