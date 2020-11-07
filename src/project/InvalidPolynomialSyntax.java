/*******************************************************************************
 * File: InvalidPolynomialSyntax.java
 * Author: Dylan Bryan
 * Date: 11/6/20, 6:28 PM
 * Project: ProjectTwo
 * Purpose: Exception class used to check exceptions in the Polynomial class
 ******************************************************************************/

package project;

/**
 * Invalid Polynomial Syntax Exception class
 */
public class InvalidPolynomialSyntax extends Exception {

  /**
   * Defines an unchecked exception from the Polynomial class
   * @param message STRING Error message supplied
   */
  public InvalidPolynomialSyntax(String message) {
    super(message);
  } // end InvalidPolynomialSyntax constructor

} // end InvalidPolynomialSyntax class
