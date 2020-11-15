/*******************************************************************************
 * File: Main.java
 * Author: Dylan Bryan
 * Date: 11/9/20, 6:57 AM
 * Project: ProjectTwo
 * Purpose: Main class containing JFileChooser class which
 * reads the input from text files and displays output
 * to the console.
 ******************************************************************************/

package project;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Main class with main method
 */
public class Main {

  public static void main(String[] args) {
    String currentLine;
    List<Polynomial> arrayList = new ArrayList<>();
    OrderedList orderedList = new OrderedList();
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
        // alert user to beginning of file reading
        System.out.println("********* BEGINNING OF FILE READING *********");
        // while there are items left in the file to read
        while ((currentLine = reader.readLine()) != null) {
          // create new polynomial object from current line in file
          polynomial = new Polynomial(currentLine);
          // add new polynomial object to array list
          arrayList.add(polynomial);
          // print out the current line item in the toString format
          System.out.println(polynomial.toString());
        } // end while loop for reading

        // alert user to end of reading in file
        System.out.println("********* END OF FILE READING *********");

        // print out the sorted linked list
        System.out.println("********* SORTED LINKED LIST *********");

        int count = 0;
        Polynomial currentList;
        while (count < arrayList.size()) {
          // current polynomial
          currentList = arrayList.get(count);
          // current linked list to iterate
          Iterator iterator = currentList.linkedList.iterator();
          // print out the current polynomial
          while (iterator.hasNext()) {
            Object nextItem = iterator.next();
            if (nextItem.toString().contains("0.0x")) {
              System.out.print("");
            } else {
              System.out.printf("%s ", nextItem);
            }
            if (iterator.hasNext() && !nextItem.toString().contains("0.0x")) {
              System.out.print("+ ");
            }
          } // end while loop
          System.out.println("");
          // increase size
          count++;
        } // end while loop
        System.out.println("********* END SORTED LINKED LIST *********");

        System.out.println("********* DETERMINE HOW LIST IS SORTED *********");
        // check how the list is sorted
        if (orderedList.checkSorted(arrayList)) {
          System.out.println("Polynomial list ordered by STRONG ORDER");
        } else {
          System.out.println("Polynomial list ordered by WEAK ORDER");
        } // end if/else statement
        // catch any errors and display them as JOptionPane window
      } catch (NumberFormatException | IOException | InvalidPolynomialSyntax e) {
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
} // end Main class
