/*******************************************************************************
 * File: Polynomial.java
 * Author: Dylan Bryan
 * Date: 11/6/20, 6:32 PM
 * Project: ProjectTwo
 * Purpose: Polynomial class, containing nested linked list class,
 * each polynomial contains its own linked list which will be added
 * to the array list in the main class
 ******************************************************************************/

package project;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Polynomial class which defines individual polynomial object
 * @param <T>
 */
public class Polynomial<T extends Comparable<T>> {
  public Linked linkedList;
  private String polynomial;
  private static final String REGEX = "[A-Z|a-z|_|(|)|\\+|\\-|\\/|\\*|]";

  /**
   * Polynomial constructor which takes in a string,
   * sets that string to the polynomial instance variable.
   * Then continues to split the polynomial up and add it
   * to the linked list.
   * @param polynomial
   * @throws InvalidPolynomialSyntax
   */
  public Polynomial(String polynomial) throws InvalidPolynomialSyntax {
    double coefficient = 0;
    int exponent = 0;
    // catch any characters that are not allowed to be in text file
    boolean matches = Pattern.compile(REGEX).matcher(polynomial).lookingAt();
    // if there is a match, throw an Invalid Polynomial Error
    if (matches) {
      throw new InvalidPolynomialSyntax("Improper Coefficient of Exponent types used in file.");
    } else {
      // check if head is null
      if (linkedList == null) {
        this.linkedList = new Linked();
      } // end if statement
      // split the string of the polynomial and loop over it
      String[] polynomialArray = polynomial.split(" ");
      for (int i = 0; i < polynomialArray.length; i++) {
        int divisibleByTwo = (i % 2);
        // get the coefficient and exponent out
        switch (divisibleByTwo) {
          case 0:
            coefficient = Double.parseDouble(polynomialArray[i]);
            break;
          case 1:
            exponent = Integer.parseInt(polynomialArray[i]);
            break;
        } // end switch statement

        // create a new node
        if ((i % 2) != 0 && i > 0) {
          Element element = new Element(coefficient, exponent);
          linkedList.add(element);
        } // end if statement

      } // end for loop
      this.polynomial = polynomial;
    } // end if/else statement
  } // end Polynomial constructor

  /**
   * Compares two different elements to be
   * used in determining whether the array
   * list is sorted by the strong or weak order
   * @param polynomial
   * @return
   */
  public int compareTo(Polynomial polynomial) {
    Element current = this.linkedList.head.element;
    Element other = polynomial.linkedList.head.element;
    Element next = this.linkedList.head.next.element;
    Element otherNext = polynomial.linkedList.head.next.element;

    if (polynomial.linkedList.head != null &&
        this.linkedList.head != null) {
      if (current.exponent != other.exponent) {
        return current.exponent - other.exponent;
      } else if (current.exponent == other.exponent &&
              current.coefficient != other.coefficient) {
        return (int) (current.coefficient - other.coefficient);
      } else if (current.exponent == other.exponent &&
                  current.coefficient == other.coefficient) {
        if (next.exponent != otherNext.exponent) {
          return otherNext.exponent - next.exponent;
        } else if (next.exponent == otherNext.exponent) {
          return (int) (next.coefficient - otherNext.coefficient);
        } // end if/else if statement
      } // end if/else if statement
    } // end if statement
    return 0;
  } // end compareTo method

  /**
   * Element class which defines the coefficient
   * and exponent data points which will be used
   * in the linked list
   */
  public static class Element implements Comparable<Element> {
    private double coefficient;
    private int exponent;

    /**
     * Element Constructor
     * @param coefficient DOUBLE coefficient
     * @param exponent INTEGER exponent
     */
    public Element(double coefficient, int exponent) {
      this.coefficient = coefficient;
      this.exponent = exponent;
    } // end constructor

    /**
     * Compares one element to another for sorting
     * purposes in the linked list
     * @param other ELEMENT Another element
     * @return INTEGER Determines how much larger item is
     */
    @Override
    public int compareTo(Element other) {
      if (exponent != other.exponent) {
        return other.exponent - exponent;
      } else if (exponent == other.exponent &&
              coefficient != other.coefficient) {
        return (int) (other.coefficient - coefficient);
      } else if (exponent == other.exponent &&
              coefficient == other.coefficient) {
        return -1;
      } // end if/else if statement
      return 0;
    } // end compareTo method

    /**
     * Creates a string representation of the element
     * @return STRING Element in string format
     */
    @Override
    public String toString() {
      String exp = "";
      if (exponent > 1 || exponent < 0) {
        exp = "x^" + exponent;
      } else if (exponent == 1) {
        exp = "x";
      } else if (exponent == 0) {
        exp = "";
      }
      return coefficient + exp;
    } // end toString method

  } // end Element class

  /**
   * Linked List class used for containing an individual Polynomial
   * @param <T>
   */
  public static class Linked<T extends Comparable<T>> {
    private Node<T> head;
    Comparator comparator = Comparator.reverseOrder();

    /**
     * Individual Node class to contain data
     * @param <T>
     */
    public static class Node<T> {
      private Element element;
      private Node<T> next;
    } // end Node class

    /**
     * Sets the head of the list to the
     * return value of adding head with
     * the element object to be added
     * @param element ELEMENT element to be added
     * @return BOOLEAN true
     */
    public boolean add(Element element) {
      head = add(head, element);
      return true;
    } // end add method

    /**
     * Add method which checks to see if the
     * Node being added is null or if the
     * comparator returns a value greater than 0
     * before adding it to maintain highest exponent
     * value first. Otherwise will recurse into the
     * next node and add the element there.
     * @param node NODE node item to be added
     * @param element ELEMENT element to be added
     * @return NODE
     */
    private Node<T> add(Node<T> node, Element element) {
      if (node == null || comparator.compare(element, node.element) > 0) {
        Node<T> newNode = new Node<>();
        newNode.element = element;
        newNode.next = node;
        return newNode;
      } else {
        node.next = add(node.next, element);
        return node;
      } // end if/else statement
    } // end add method

    /**
     * List iteration class which creates a new
     * Iterator object to be used in iterating
     * over the linked list
     */
    public class ListIterator implements Iterator<T> {
      Node<T> current;

      @Override
      public boolean hasNext() {
        if (current == null) {
          return head != null;
        } else {
          return current.next != null;
        } // end if/else statement
      } // end hasNext method

      @Override
      public T next() {
        if (current == null) {
          current = head;
        } else {
          current = current.next;
        } // end if/else statement
        return (T) current.element;
      } // end next method

    } // end ListIterator class

    public Iterator<T> iterator() {
      return new ListIterator();
    } // end iterator method

  } // end LinkedList class

  /**
   * Converts a polynomial object to a string, ensures
   * that terms with 0 coefficients
   * @return STRING polynomial in string format
   */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    String[] polyArray = polynomial.split(" ");
    double currentCoefficient = 0;
    int currentExponent = 0;

    for (int i = 0; i < polyArray.length; i++) {
      int divisibleByTwo = (i % 2);
      switch (divisibleByTwo) {
        case 0:
          currentCoefficient = Double.parseDouble(polyArray[i]);
          // if the coefficient does not equal to zero, omit the coefficient
          if (currentCoefficient != 0) {
            output.append(currentCoefficient);
          }
          break;
        case 1:
          currentExponent = Integer.parseInt(polyArray[i]);
          if (currentExponent > 1 && currentCoefficient != 0) {
            output.append("x^" + currentExponent);
            if (i < polyArray.length - 1) {
              output.append(" + ");
            } // end if statement
          } else if (currentExponent == 1 && currentCoefficient != 0) {
            if (i < polyArray.length - 1) {
              output.append("x + ");
            }
          }
          break;
      } // end switch statement
    } // end for loop
    return String.valueOf(output);
  } // end toString method
} // end Polynomial class