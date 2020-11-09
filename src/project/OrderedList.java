/*******************************************************************************
 * File: OrderedList.java
 * Author: Dylan Bryan
 * Date: 11/6/20, 7:59 PM
 * Project: ProjectTwo
 * Purpose: Lorem ipsum dolor sit amet
 ******************************************************************************/

package project;

import java.util.Comparator;
import java.util.List;

public class OrderedList {
  /*
    todo: Utility class that contains <strong>TWO</strong> overloaded implementations of a method called
          `checkSorted`, which determines whether a `List` object, supplied as parameter,
            is in strictly ascending order. (Both should be `Static` methods)
              - The first should accept a `List` that contains elements that implement `Comparable`
              - The second should instead be supplied an additional parameter that is an object of
                a class that implements the `Comparator` interface.
              - Refer to the signatures of the two `sort` methods in the predefined Java `Collections`
                class as a model for how these two methods should be defined.
              - Ensure that the first overloaded method calls the second
  */

  public <T extends Comparable<? super T>> void checkSorted(List<T> list) {
    list.sort(null);
  } // end checkSorted method

  public <T> void checkSorted(List<T> list, Comparator<? super T> c) {
    list.sort(c);
  } // end checkSorted method

} // end OrderedList class
