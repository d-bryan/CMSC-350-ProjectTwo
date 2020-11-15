# CMSC 350 Project 2

Program examines a file of polynomials and determines whether the polynomials in the
file are in strictly ascending order using two different methods of comparison

Each line of the input file will contain one polynomial. On each line will be the terms
of the polynomial. Each term will be represented as a pair of values. The first element
of that pair is a real value that represents the coefficient and the second an integer
value, which is its corresponding exponent. For examples, 5.6 3 4 1 8.3 0 represents
the polynomial 5.6x<sup>3</sup> + 4x + 8.3. They are intended to be written from the 
highest exponent to the lowest, but ensuring that is true is a program requirement. 
Exponents with zero coefficients will be omitted.  

## Polynomial Class

- Should define an individual polynomial.
- Polynomial Objects should be represented internally by a singly linked list.
- Each Node should contain one term of the polynomial consisting of its 
    coefficient and exponent (Not permitted to use the pre-defined LinkedList class)
    Instead you must create the nodes of the linked list as instances of a 
    static nested class inside the `Polynomial` class.
- `Polynomial` class Must implement both the `Iterable` and `Comparable` interfaces. 
- Must have four public methods.

### Constructor

- Accepts a string that defines one polynomial in the same format as provided in the input file

### compareTo method 

- Compares two polynomials
- If two polynomials have different highest order components, the one with the highest exponent
    is the greatest.
- If their highest exponents are the same, their coefficients are compared.
- If two polynomials have the same highest order exponent with the same coefficients,
    the next highest exponent is examined, and so on. 

### iterator method

- Produces an iterator that iterates across the terms of the polynomial from highest exponent
    to lowest and returns an object that contains only the coefficient and exponent of the
    next term.

### toString method

- Converts a polynomial to a string.
- Terms with 0 coefficients should be omitted entirely.
- The exponent of the term with an exponent of 1 should omit the exponent and the
    term with exponent 0 should omit the variable x as well.
- Example: "5.6 3 4 1 8.3 0" should be converted to the following string -><br>
    "5.6x<sup>3</sup> + 4x + 8.3"

## Invalid Polynomial Syntax Class

- Defines an unchecked exception that contains a constructor, which allows a message
    to be supplied. 
- It is thrown by the constructor in the `Polynomial` class, should
    the supplied string contain coefficients or exponents of an improper type, 
    or should exponents fail to be listed in strictly descending order.

## Ordered List class

- Utility class that contains <strong>TWO</strong> overloaded implementations of a method called
    `checkSorted`, which determines whether a `List` object, supplied as parameter,
    is in strictly ascending order. (Both should be `Static` methods)
- The first should accept a `List` that contains elements that implement `Comparable`
- The second should instead be supplied an additional parameter that is an object of
    a class that implements the `Comparator` interface.
- Refer to the signatures of the two `sort` methods in the predefined Java `Collections`
    class as a model for how these two methods should be defined.
- Ensure that the first overloaded method calls the second

## Main class

- A named `lambda expression` should be defined that implements the `Comparator`
    interface. Its `compare` method should consider only the exponents and not the
    coefficients in comparing polynomials, much like how functions are categorized
    by Big-O.

#### Example List

4.0x<sup>3</sup> + 2.5x + 8.0<br>
5.0x<sup>4</sup> + 5.0<br>
4.5x<sup>4</sup> + 5.7x<sup>2</sup> + 8.6<br>

This list fails to be sorted by the strong order that considers both the coefficient
and exponents because the third polynomial is less than the second because coefficients
on the x<sup>4</sup> terms. The coefficient on that term in the second polynomial is 5.0,
which is greater than 4.5, the coefficient on the corresponding term in the third polynomial.

They are sorted by the weak order that considers only the exponents, however. The third 
polynomial is greater than the second because the third has a x<sup>2</sup> term and
the second one does not.

### main method

- Allow the user to select the input file from the default directory by using
    an object of the `JFileChooser` class.
- It should then populate and `ArrayList` of objects of type `Polynomial` as
    it reads in the lines from the file.
- As the polynomials are read in, they should also be displayed in the format
    provided by the `toString` method.
- Should the `InvalidPolynomialSyntax` exception be thrown, it should be caught
    and a `JOptionPane` message should be displayed containing the reason for
    the invalid syntax
- List of polynomials should be then checked to see whether it is in sorted order
    according to two things:
    - First check is the one that uses the `compareTo` method of the `Polynomial`
        class. We refer to this first ordering by the strong order.
    - Second results come from the use of a comparator. We refer to this as the 
        weak order. 
    - It should display whether it fails to be sorted by either or
        both of the two orderings or if it is sorted according to both.
