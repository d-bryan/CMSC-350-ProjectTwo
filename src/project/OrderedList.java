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

  public <T extends Comparable<? super T>> void checkSorted(List<T> list) {
    list.sort(null);
  } // end checkSorted method

  public <T> void checkSorted(List<T> list, Comparator<? super T> c) {
    list.sort(c);
  } // end checkSorted method

} // end OrderedList class
