/*******************************************************************************
 * File: Main.java
 * Author: Dylan Bryan
 * Date: 11/9/20, 6:57 AM
 * Project: ProjectTwo
 * Purpose: Lorem ipsum dolor sit amet
 ******************************************************************************/

package project;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
  /*
    todo: A named `lambda expression` should be defined that implements the `Comparator`
      interface. Its `compare` method should consider only the exponents and not the
      coefficients in comparing polynomials, much like how functions are categorized
      by Big-O.
  */

  /*
  todo: Allow the user to select the input file from the default directory by using
        an object of the `JFileChooser` class.
          - It should then populate and `ArrayList` of objects of type `Polynomial` as
            it reads in the lines from the file.
          - As the polynomials are read in, they should also be displayed in the format
            provided by the `toString` method.
  todo: Should the `InvalidPolynomialSyntax` exception be thrown, it should be caught
        and a `JOptionPane` message should be displayed containing the reason for
        the invalid syntax
  todo: List of polynomials should be then checked to see whether it is in sorted order
        according to two things:
          - First check is the one that uses the `compareTo` method of the `Polynomial`
            class. We refer to this first ordering by the strong order.
          - Second results come from the use of a comparator. We refer to this as the
            weak order.
          - It should display whether it fails to be sorted by either or
            both of the two orderings or if it is sorted according to both.
  */

  public static void main(String[] args) {
    String currentLine;
    int numberOfPolynomials = 0, placeholder = 0;
    ArrayList<Polynomial> arrayList = new ArrayList<>();
//    LinkedListTest linkedListTest = new LinkedListTest();
//    Iterator iterator = linkedListTest.iterator();
    Polynomial polynomial;
    JFileChooser fileChooser = new JFileChooser(new File("src"));
    int returnFile = fileChooser.showOpenDialog(null);
    // check if user selected ok
    if (returnFile == JFileChooser.APPROVE_OPTION) {
      // get selected file
      File selectedFile = fileChooser.getSelectedFile();

      try {
        // get file from JFileChooser
        FileReader fileReader = new FileReader(selectedFile.getAbsolutePath());
        // read input into reader
        BufferedReader reader = new BufferedReader(fileReader);
        // String builder for output
        StringBuilder output = new StringBuilder();
        // while there are items left in the file to read
        while ((currentLine = reader.readLine()) != null) {
          String[] lineItem = currentLine.split(" ");
          StringBuilder currentPolynomial = new StringBuilder();
//          System.out.println(lineItem);
          double coefficient = 0;
          int exponent = 0;
          for(int i = 0; i < lineItem.length; i++) {
            int divisibleByTwo = (i % 2);
            switch (divisibleByTwo) {
              case 0:
                coefficient = Double.parseDouble(lineItem[i]);
                currentPolynomial.append(lineItem[i]);
                break;
              case 1:
                exponent = Integer.parseInt(lineItem[i]);
                currentPolynomial.append(lineItem[i]);
                break;
            } // end switch statement



            if (numberOfPolynomials == lineItem.length - 1) {
              polynomial = new Polynomial(String.valueOf(currentPolynomial));
              arrayList.add(polynomial);
            }
            numberOfPolynomials++;

//            // if both coefficient and exponent have been parsed
//            // create a new polynomial object
//            if ((i % 2) != 0 && i > 0) {
//              polynomial = new Polynomial(coefficient, exponent);
//              linkedListTest.add(polynomial);
//            } // end if statement
//            numberOfPolynomials++;
          } // end for loop
//          System.out.println(currentPolynomial);

//          // add items to the string builder for output
//          while (iterator.hasNext()) {
//            output.append(iterator.next());
//            if (placeholder < (numberOfPolynomials / 2) - 1) {
//              output.append(" + ");
//            }
//            placeholder++;
//          } // end while loop
//          output.append("\n");

//          // reset iterator and linked list
//          linkedListTest = new LinkedListTest();
//          iterator = linkedListTest.iterator();
          placeholder = 0;
          numberOfPolynomials = 0;

        } // end while loop for reading
        int count = 0;
        while (!arrayList.isEmpty()) {
          System.out.println(arrayList.get(count));
          count++;
        }
//        System.out.println(output);

      } catch (IOException | InvalidPolynomialSyntax e) {
        JOptionPane.showConfirmDialog(null,
                e.getMessage(),
                "Error Processing File",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        e.printStackTrace();
      } // end try/catch block

    } // end JFileChooser selection
  } // end main method

//  public static Comparator<Polynomial> getCompare() {
//
//    return (Polynomial first, Polynomial second) -> {
//
//    };
//  } // end comparator method

} // end Main class
