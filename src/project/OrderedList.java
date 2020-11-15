/*******************************************************************************
 * File: OrderedList.java
 * Author: Dylan Bryan
 * Date: 11/6/20, 7:59 PM
 * Project: ProjectTwo
 * Purpose: Utility class which checks whether the array list of linked lists
 * is sorted in a strong order or weak order
 ******************************************************************************/

package project;

import java.util.List;

/**
 * Ordered List class to check whether list is sorted
 */
public class OrderedList {

  /**
   * Calls the second checkSorted method with the original
   * list passed in and the size of the list as parameters
   * @param list LIST Array List of type Polynomial
   * @return BOOLEAN true/false
   */
  public static boolean checkSorted(List<Polynomial> list) {
    return checkSorted(list, list.size());
  } // end checkSorted method

  /**
   * Recursive check as to whether the list is sorted in the
   * strong or weak order, using the compareTo method from
   * the Polynomial class.
   * @param list LIST Array List of type Polynomial
   * @param index Starting index from size of list
   * @return BOOLEAN true/false
   */
  public static boolean checkSorted(List<Polynomial> list, int index) {
    if (index < 2) {
      return true;
    } else if (list.get(index - 2).compareTo(list.get(index - 1)) > 0) {
      return false;
    } else {
      return checkSorted(list, index - 1);
    } // end if/else if/else statement
  } // end checkSorted method

} // end OrderedList class
