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
  /*
    todo: Defines an unchecked exception that contains a constructor, which allows a message
          to be supplied.
    todo: It is thrown by the constructor in the `Polynomial` class, should
          the supplied string contain coefficients or exponents of an improper type,
          or should exponents fail to be listed in strictly descending order.
  */

  /**
   * Defines an unchecked exception from the Polynomial class
   * @param message STRING Error message supplied
   */
  public InvalidPolynomialSyntax(String message) {
    super(message);
  } // end InvalidPolynomialSyntax constructor

} // end InvalidPolynomialSyntax class
