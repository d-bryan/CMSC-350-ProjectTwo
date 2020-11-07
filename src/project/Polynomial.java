/*******************************************************************************
 * File: Polynomial.java
 * Author: Dylan Bryan
 * Date: 11/6/20, 6:32 PM
 * Project: ProjectTwo
 * Purpose: Lorem ipsum dolor sit amet
 ******************************************************************************/

package project;

import java.util.Iterator;

public class Polynomial<T> implements Iterable<T>, Comparable<T> {
  private String polynomial;

  /**
   * Creates a new polynomial object
   * @param polynomial STRING polynomial
   */
  public Polynomial(String polynomial) {
    this.polynomial = polynomial;
  } // end constructor

  /**
   * Linked List class
   * @param <T> Polynomial term
   */
  private static class Node<T> {
    private T element;
    private Node<T> next;
  } // end Node class

  @Override
  public int compareTo(T o) {
    return 0;
  } // end compareTo method

  @Override
  public Iterator<T> iterator() {
    return null;
  } // end iterator method

  @Override
  public String toString() {
    return "Polynomial{" +
            "polynomial='" + polynomial + '\'' +
            '}';
  } // end toString method

} // end Polynomial class
