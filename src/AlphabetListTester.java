//////////////// FILE HEADER //////////////////////////
//
// Title: P06 Alphabet List
// Files: AlphabetList, AlphabetListTester, LinkedCart, Cart, SortedListADT
// Course: CS300,Spring, 2020
//
// Author: Meng Tian
// Email: mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:   NONE      (identify each person and describe their help in detail)
// Online Sources: NONE (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
    // test the default constructor and all get methods
    LinkedCart list1 = new LinkedCart(new Cart("A"));
    if (list1.getNext() != null)
      return false;
    if (list1.getPrevious() != null)
      return false;
    if (!list1.getCart().getCargo().equals("A"))
      return false;
    // test the set methods
    list1.setPrevious(new LinkedCart(new Cart("B")));
    if (!list1.getPrevious().getCart().getCargo().equals("B"))
      return false;
    list1.setNext(new LinkedCart(new Cart("C")));
    if (!list1.getNext().getCart().getCargo().equals("C"))
      return false;
    // test the second constructor
    LinkedCart pre = new LinkedCart(new Cart("E"));
    LinkedCart after = new LinkedCart(new Cart("F"));
    LinkedCart list2 = new LinkedCart(new Cart("D"), pre, after);
    if (!list2.getNext().getCart().getCargo().equals("F"))
      return false;
    if (!list2.getPrevious().getCart().getCargo().equals("E"))
      return false;
    if (!list2.getCart().getCargo().equals("D"))
      return false;
    // test the set methods
    list2.setPrevious(new LinkedCart(new Cart("B")));
    if (!list2.getPrevious().getCart().getCargo().equals("B"))
      return false;
    list2.setNext(new LinkedCart(new Cart("C")));
    if (!list2.getNext().getCart().getCargo().equals("C"))
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
    // create a empty alphabetlist using default constructor
    AlphabetList list1 = new AlphabetList();
    if (list1.isEmpty() != true)
      return false;
    // check its capacity
    if (list1.capacity() != 26)
      return false;
    // add a new cart
    list1.add(new Cart("A"));
    if (list1.isEmpty() != false)
      return false;
    // create a empty alphabetlist using other constructor
    AlphabetList list2 = new AlphabetList(10);
    if (list2.isEmpty() != true)
      return false;
    if (list2.capacity() != 10)
      return false;
    // add a new cart
    list2.add(new Cart("A"));
    if (list2.isEmpty() != false)
      return false;
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
    try {
      AlphabetList list1 = new AlphabetList(-1);// invalid input
      System.out.println("Problem detected. The constructor call of the AlphabetList class did not "
          + "throw an IllegalArgumentException when it is passed a negative capacity.");// if it
                                                                                        // does not
                                                                                        // throw any
                                                                                        // exception,
                                                                                        // then
                                                                                        // throw a
                                                                                        // warning
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null || !e1.getMessage().toLowerCase()
          .contains("capacity of this list must be a non-zero positive integer")) {// if it throws
                                                                                   // the right
                                                                                   // exception with
                                                                                   // message
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList class when it is passed a negative capacity "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the AlphabetList class with a negative argument. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
    AlphabetList list1 = new AlphabetList();
    /** Try adding a null to the list */
    try {
      list1.add(null);
      System.out.println("Problem detected. The add method of the AlphabetList class did not "
          + "throw an IllegalArgumentException when it is passed null object.");// if it does not
                                                                                // throw any
                                                                                // exception, then
                                                                                // throw a warning
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null || !e1.getMessage().toLowerCase()
          .contains("only add carts carrying one upper-case alphabetic letter in the range")) {// if
                                                                                               // it
                                                                                               // throws
                                                                                               // the
                                                                                               // right
                                                                                               // exception
                                                                                               // with
                                                                                               // message
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList class when it is passed a null object "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "add method of the AlphabetList class with a null input. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    /** (2) Try adding a cart which carries a non upper-case alphabet letter */
    /** invalid input - not a single upper-case letter */
    try {
      list1.add(new Cart("Hello"));
      System.out.println("Problem detected. The add method of the AlphabetList class did not "
          + "throw an IllegalArgumentException when it is passed invalid object.");
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null // if it throws the right exception with message
          || !e1.getMessage().toLowerCase()
              .contains("only add carts carrying one upper-case alphabetic letter in the range")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList class when it is passed a invalid input "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "add method of the AlphabetList class with a invalid input. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    /** invalid input - lower-case letter */
    try {
      list1.add(new Cart("a"));
      System.out.println("Problem detected. The add method of the AlphabetList class did not "
          + "throw an IllegalArgumentException when it is passed invalid object.");// if it does not
                                                                                   // throw any
                                                                                   // exception,
                                                                                   // then throw a
                                                                                   // warning
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null // if it throws the right exception with message
          || !e1.getMessage().toLowerCase()
              .contains("only add carts carrying one upper-case alphabetic letter in the range")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList class when it is passed a invalid input "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "add method of the AlphabetList class with a invalid input. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    /** invalid input - number */
    try {
      list1.add(new Cart("1"));
      System.out.println("Problem detected. The add method of the AlphabetList class did not "
          + "throw an IllegalArgumentException when it is passed invalid object.");// if it does not
                                                                                   // throw any
                                                                                   // exception,
                                                                                   // then throw a
                                                                                   // warning
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null // if it throws the right exception with message
          || !e1.getMessage().toLowerCase()
              .contains("only add carts carrying one upper-case alphabetic letter in the range")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList class when it is passed a invalid input "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "add method of the AlphabetList class with a invalid input. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    /** (3) Try adding a duplicate cart to the list */
    try {
      list1.add(new Cart("A"));
      list1.add(new Cart("A"));
      System.out.println("Problem detected. The add method of the AlphabetList class did not "
          + "throw an IllegalArgumentException when it is passed duplicate object.");// if it does
                                                                                     // not throw
                                                                                     // any
                                                                                     // exception,
                                                                                     // then throw a
                                                                                     // warning
    } catch (IllegalArgumentException e1) {
      if (e1.getMessage() == null // if it throws the right exception with message
          || !e1.getMessage().toLowerCase().contains("duplicate letters or carts in this list")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the AlphabetList class when it is passed a duplicate input "
                + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "add method of the AlphabetList class with a duplicate input. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
    AlphabetList letters = new AlphabetList();
    /** (1) Try adding a cart to an empty list */
    Cart h = new Cart("H");
    letters.add(h);
    if (letters.size() != 1)
      return false;// if the size increases one
    if (!letters.get(0).getCargo().equals("H"))
      return false;// if it contains same cargo
    if (letters.indexOf(h) != 0)
      return false;// if the cart has index 0
    /**
     * (2) Try adding a cart which is expected to be added at the head of a non-empty alphabet list;
     */
    Cart f = new Cart("F");
    letters.add(f);
    Cart j = new Cart("J");
    letters.add(j);
    Cart a = new Cart("A");
    letters.add(a);
    if (letters.size() != 4)
      return false;// if it gets correct size
    if (!letters.get(0).getCargo().equals("A"))
      return false;// if the head has cargo A
    if (letters.indexOf(a) != 0)
      return false;// if the cart with cargo A has index 0
    /**
     * (3) Try adding a cart which is expected to be added at the end of a non-empty alphabet list
     */
    Cart z = new Cart("Z");
    letters.add(z);
    if (!letters.get(letters.size() - 1).getCargo().equals("Z"))
      return false;// if the last cart has cargo Z
    if (letters.indexOf(z) != letters.size() - 1)
      return false;// if it has index size-1
    /**
     * (4) Try adding a cart which is expected to be added at the middle of a non-empty alphabet
     * list.
     */
    Cart i = new Cart("I");
    letters.add(i);
    if (!letters.get(3).getCargo().equals("I"))
      return false; // if the third cart has cargo I
    if (letters.indexOf(i) != 3)
      return false;// if the cart has index of 3
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. (6) Try to remove a cart from a list containing
   * only one cart. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {


    /**
     * (1) Try removing a cart from an empty list or pass a negative index to AlphabetList.remove()
     * method
     */
    AlphabetList letters = new AlphabetList();
    try {
      letters.remove(1);
      System.out.println("Problem detected. The remove method of the AlphabetList class did not "
          + "throw an IndexOutOfBoundsException when it is removed a object from a empty list.");// if
                                                                                                 // it
                                                                                                 // does
                                                                                                 // not
                                                                                                 // throw
                                                                                                 // any
                                                                                                 // exception,
                                                                                                 // then
                                                                                                 // throw
                                                                                                 // a
                                                                                                 // warning
    } catch (IndexOutOfBoundsException e1) {
      if (e1.getMessage() == null // if it throws the right exception with message
          || !e1.getMessage().toLowerCase().contains("index")) {
        System.out.println("Problem detected. The IndexOutOfBoundsException thrown by the remove "
            + "call of the AlphabetList class when it is removed a object from a empty list "
            + "does not contain an appropriate error message.");
        return false;
      }
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "remove method of the AlphabetList class with a invalid input. "
              + "An IndexOutOfBoundsException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    /** (2) Try removing a cart (at position index 0) from a list which contains only one cart */
    Cart h = new Cart("H");
    letters.add(h);
    Cart cart = null;
    try {
      cart = letters.remove(0);
    } catch (Exception e) {
      return false;
    } // if there is any other exceptions
    if (!cart.getCargo().equals("H"))
      return false;// if the removed cart has cargo H
    if (letters.size() != 0)
      return false;// if the alphabetlist has size = 0
    if (letters.isEmpty() != true)
      return false;// if it is empty
    /** (3) Try to remove a cart (position index 0) from a list which contains at least 2 carts */
    letters.add(new Cart("F"));
    letters.add(new Cart("J"));
    Cart cart2 = null;
    try {
      cart2 = letters.remove(0);
    } catch (Exception e) {
      return false;
    } // if the cart is successfully removed
    if (!cart2.getCargo().equals("F"))
      return false;// if the cargo equals F
    if (letters.size() != 1)
      return false;// if the other cart remains in the list
    if (letters.isEmpty() != false)
      return false;// if it is empty
    /** (4) Try to remove a cart from the middle of a non-empty list containing at least 3 carts */
    letters.add(new Cart("D"));
    letters.add(new Cart("G"));
    letters.add(new Cart("B"));
    letters.add(new Cart("X"));
    Cart cart3 = null;
    try {
      cart3 = letters.remove(2);
    } catch (Exception e) {
      return false;
    }
    if (!cart3.getCargo().equals("G"))
      return false;// if it removes the right cart
    if (letters.size() != 4)
      return false;// if the size is correct
    if (letters.isEmpty() != false)
      return false;// if it is empty
    /** (5) Try to remove the cart at the end of a list containing at least two carts. */
    Cart cart4 = null;
    try {
      cart4 = letters.remove(letters.size() - 1);
    } catch (Exception e) {
      return false;
    }
    if (!cart4.getCargo().equals("X"))
      return false;// if it removes the right cart
    if (letters.isEmpty() != false)
      return false;// if it is empty
    if (!letters.readForward().equals("BDJ"))
      return false;// if it can be read forward in a correct order
    if (!letters.readBackward().equals("JDB"))
      return false;// if it can be read backward in a correct order

    return true;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (testLinkedCart() == false || testAlphabetListConstructorIsEmpty() == false
        || testAlphabetListConstructorBadInput() == false || testAlphabetListAddBadInput() == false
        || testAlphabetListAdd() == false || testAlphabetListRemove() == false)
      return false;
    return true;
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println("runAllTests: " + runAllTests());
  }
}
