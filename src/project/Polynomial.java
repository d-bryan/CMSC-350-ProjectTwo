/*******************************************************************************
 * File: Polynomial.java
 * Author: Dylan Bryan
 * Date: 11/6/20, 6:32 PM
 * Project: ProjectTwo
 * Purpose: Lorem ipsum dolor sit amet
 ******************************************************************************/

package project;

import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

//Comparable<Polynomial>
public class Polynomial<T extends Comparable<T>> implements Iterable<T> {
  /*
  todo: Should define an individual polynomial.
  todo: Polynomial Objects should be represented internally by a singly linked list.
  todo: Each Node should contain one term of the polynomial consisting of its
        coefficient and exponent (Not permitted to use the pre-defined LinkedList class)
        Instead you must create the nodes of the linked list as instances of a
        static nested class inside the `Polynomial` class.
  */
//  Comparator<T> comparator;
  private Node<T> head, tail;
  private int size = 0;
  private String polynomial;
  private static final String REGEX = "^[^A-Za-z_()\\+\\-\\/\\*]+$";
//  private double coefficient;
//  private int exponent;

//  public Polynomial(double coefficient, int exponent) {
//    // todo: Accepts a string that defines one polynomial in the same format as provided in the input file
//    this.coefficient = coefficient;
//    this.exponent = exponent;
////    this.comparator = Comparator.reverseOrder()
//  } // end constructor

  public Polynomial(String polynomial) throws InvalidPolynomialSyntax {
    boolean matches = Pattern.compile(REGEX).matcher(polynomial).find();
    if (matches) {
      throw new InvalidPolynomialSyntax("Improper Coefficient of Exponent types used.");
    } else {
      for (int i = 0; i < polynomial.length(); i++) {
        StringTokenizer tokenizer = new StringTokenizer(polynomial);
      }
      this.polynomial = polynomial;
    } // end if/else statement
  } // end Polynomial constructor

  /**
   * Linked List private class
   * @param <T>
   */
  private static class Node<T> {
    private T coefficient;
    private T exponent;
    private Node<T> next;
  } // end Node class

  public int compareTo(Polynomial other) {
    Node<T> current;
    /*
    todo: Compares two polynomials
    todo: If two polynomials have different highest order components, the one with the highest exponent
          is the greatest.
            - If their highest exponents are the same, their coefficients are compared.
            - If two polynomials have the same highest order exponent with the same coefficients,
              the next highest exponent is examined, and so on.
    */

    // check exponent values
//    if (exponent != other.exponent) {
//      return exponent - other.exponent;
//    } else if (exponent == other.exponent) {
//      return (int) (coefficient - other.coefficient);
//    } else if (exponent == other.exponent &&
//            coefficient == other.coefficient) {
//      return -1;
//    }
//    return 0;
//    return (int) (coefficient - other.coefficient);
    return 0;
  } // end compareTo method

  @Override
  public String toString() {
    /*
    todo: Converts a polynomial to a string.
            - Terms with 0 coefficients should be omitted entirely.
            - The exponent of the term with an exponent of 1 should omit the exponent and the
              term with exponent 0 should omit the variable x as well.
            - Example: "5.6 3 4 1 8.3 0" should be converted to the following string -><br>
            "5.6x<sup>3</sup> + 4x + 8.3"
    */
//    String exp = (exponent <= 0) ? "" : "^" + exponent;
//    return coefficient + exp;
    return "";
  } // end toString method

//  public static Comparator<Polynomial> getCompare() {
//    return (Polynomial left, Polynomial right) -> {
//      if (left.exponent != right.exponent) {
//        return left.exponent - right.exponent;
//      } // end if statement
//      return (int) (left.coefficient - right.coefficient);
//    };
//  } // end getCompare method

  @Override
  public Iterator<T> iterator() {
    /*
    Produces an iterator that iterates across the terms of the polynomial from highest exponent
    to lowest and returns an object that contains only the coefficient and exponent of the
    next term.
    */
    return new ListIterator();
  }

  public class ListIterator implements Iterator<T> {
    private Node<T> current;

    @Override
    public void remove() {

    } // end remove method

    @Override
    public boolean hasNext() {
      if (current == null) {
        return head != null;
      } else {
        return current.next != null;
      } // end if/else
    } // end hasNext

    @Override
    public T next() {
      if (current == null) {
        current = head;
      } else {
        current = current.next;
      }
      return current.exponent;
    } // end next method

  } // end ListIterator class

} // end Polynomial class


//public class Polynomial<T> implements Iterable<T>, Comparable<T> {
//  private String polynomial;
//
//  /**
//   * Creates a new polynomial object
//   * @param polynomial STRING polynomial
//   */
//  public Polynomial(String polynomial) {
//    this.polynomial = polynomial;
//  } // end constructor
//
//  /**
//   * Linked List class
//   * @param <T> Polynomial term
//   */
//  private static class Node<T> {
//    private T element;
//    private Node<T> next;
//  } // end Node class
//
//  @Override
//  public int compareTo(T o) {
//    return 0;
//  } // end compareTo method
//
//  @Override
//  public Iterator<T> iterator() {
//    return null;
//  } // end iterator method
//
//  @Override
//  public String toString() {
//    return "Polynomial{" +
//            "polynomial='" + polynomial + '\'' +
//            '}';
//  } // end toString method
//
//} // end Polynomial class
