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
 * create a class AlphabetList with its constructors and methods it implements the interface
 * SortedListADT
 */
public class AlphabetList implements SortedListADT<Cart> {
  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that
  // can be added to this sorted list
  private static final Cart MAX_CART = new Cart("Z"); // The largest cart that
  // can be added to this sorted list
  private LinkedCart head; // head of this doubly linked list
  private LinkedCart tail; // tail of this doubly linked list
  private int size; // size of this list
  private int capacity; // maximum number of carts which can be stored in this list

  /**
   * Creates a new winter carnival object
   */
  public AlphabetList() {
    // when initialization, the head and tail are all null
    this.head = null;
    this.tail = null;
    this.size = 0;
    this.capacity = 26;// the default capacity of the list is 26
  }

  /**
   * Creates a new winter carnival object
   * 
   * @param capacity the total number of Cart can be stored in the list
   * @throws IllegalArgumentException when the input is not valid
   */
  public AlphabetList(int capacity) {
    // check the input is a integer or not, throw the IllegalArgumentException if it is not
    if (capacity != (int) capacity || capacity <= 0)
      throw new IllegalArgumentException(
          "The capacity of this list must be a non-zero positive integer.");
    this.head = null;
    this.tail = null;
    this.size = 0;
    this.capacity = capacity;
  }

  /**
   * Returns the size of the alphabetlist
   * @Specifiedby size in interface SortedListADT<Cart>
   * @return the number of cart stored in the list
   */
  public int size() {
    return size;
  }

  /**
   * Returns the capacity of the alphabetlist
   * 
   * @return the number of cart can be stored in the list
   */
  public int capacity() {
    return capacity;
  }

  /**
   * Returns the status of the list that it is empty or not
   * @Specifiedby isEmpty in interface SortedListADT<Cart>
   * @return true if it is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * add a new cart into the list
   * @specifiedby add in interface SortedListADT<Cart>
   * @param newCart a Cart object that carries a cargo
   * @throws IllegelArgumentException when the input is null or not a upper-case letter or not a
   *                                  single letter, and it duplicates with another existing letter
   *                                  in the list
   * @throws IllegelStateException    when the list is full
   */
  @Override
  public void add(Cart newCart) {
    // check if the newObject is valid
    // it can only be a single upper-case letter
    if (newCart == null || newCart.compareTo(MIN_CART) < 0 || newCart.compareTo(MAX_CART) > 0
        || newCart.getCargo().length() != 1)
      throw new IllegalArgumentException(
          "Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");// if
                                                                                               // not,
                                                                                               // throw
                                                                                               // an
                                                                                               // exception
                                                                                               // with
                                                                                               // appropriate
                                                                                               // warning
    // check if it already existed in the list
    LinkedCart check = head;
    while (check != null) {
      if (newCart.getCargo().equals(check.getCart().getCargo()))
        throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");// if
                                                                                              // it
                                                                                              // is,
                                                                                              // throw
                                                                                              // an
                                                                                              // exception
                                                                                              // with
                                                                                              // appropriate
                                                                                              // warning
      check = check.getNext();
    }
    // check if the list is full already
    if (size == capacity)
      throw new IllegalStateException("This list is full. Cannot add another cart.");// if it is,
                                                                                     // throw an
                                                                                     // exception
                                                                                     // with
                                                                                     // appropriate
                                                                                     // warning
    // if the input is valid, then start adding it into the list
    // adding cart based on its cargo
    LinkedCart newObject = new LinkedCart(newCart);// put the cart into a linkedCart object

    if (size == 0) {// if it is the first object, then just add it in
      head = newObject;
      tail = newObject;
    } else {// if it is not, compare it with the head object
      LinkedCart lastNodeInList = head;
      if (head.getCart().compareTo(newObject.getCart()) >= 0) {// if it is smaller than the head,
                                                             // change the head to this new object
        head = newObject;
        newObject.setNext(lastNodeInList);
        lastNodeInList.setPrevious(newObject);
      } else {// if it is larger than the head object, compare it with the following objects
        while (lastNodeInList.getNext() != null) {
          LinkedCart nextNode = lastNodeInList.getNext();
          if (nextNode.getCart().compareTo(newObject.getCart()) >= 0) {// if there is one object that
                                                                     // larger than the new object,
                                                                     // add the new object into the
                                                                     // position that before the old
                                                                     // object
            lastNodeInList.setNext(newObject);
            nextNode.setPrevious(newObject);
            newObject.setPrevious(lastNodeInList);
            newObject.setNext(nextNode);
            break;// no more checks
          } else {
            lastNodeInList = nextNode;
          }
        }
        // if the new object is larger than all objects in the list
        // add it to the last of the list
        lastNodeInList.setNext(newObject);
        newObject.setPrevious(lastNodeInList);
        LinkedCart a = head;
        while (a.getNext() != null)
          a = a.getNext();
        tail = a;// also set it to be the tail of the list
        tail.setPrevious(a.getPrevious());
      }

    }
    size++;// size adds one

  }

  /**
   * return the cart according to its index
   * 
   * @SpecifiedBy Get in interface SortedList<Cart>
   * @param index the index of the object in the list
   * @return Cart that has the input index
   * @throws IndexOutOfBoundsException when the input index is not a positive integer smaller than
   *                                   size
   */
  @Override
  public Cart get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Invalid index.");
    LinkedCart currentCart = head;
    for (int i = 0; i < index; i++)
      currentCart = currentCart.getNext();
    return currentCart.getCart();
  }

  /**
   * find the index of certain cart
   * 
   * @Specifiedby indexOf in interface SortedList<Cart>
   * @param findCart the cart that need to be found in the list
   * @return the index of certain object, -1 if there is no such object in the list
   */
  @Override
  public int indexOf(Cart findCart) {
    LinkedCart currentCart = head;
    if (findCart.equals(currentCart.getCart()))
      return 0;
    for (int i = 1; i < size; i++) {
      currentCart = currentCart.getNext();
      if (findCart.equals(currentCart.getCart()))
        return i;
    }
    return -1;// if it is not existing, return -1


  }

  /**
   * remove a cart from the list
   * 
   * @specifiedBy remove in interface SortedList<Cart>
   * @param index the index of the cart that need to be removed
   * @throws IndexOutOfBoundsException when the input index is not a valid number
   * @return the cart that removed out
   */
  @Override
  public Cart remove(int index) {
    // check if the index is valid, i.e. it is a positive integer that smaller than its size
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("Invalid index");
    Cart originCart = get(index);// get the cart that need to be removed
    LinkedCart currentCart = head;
    if (index == 0) {// if it is the head cart in the list
      head = currentCart.getNext();// the head changes to the next one
      if (size == 1)
        tail = null;// if it is the only object in the list, then both head and tail are null
      if (size != 1)
        head.setPrevious(null);// the second one becomes the head and it does not have previous
                               // object
    } else if (index == size - 1) {// if it is the tail cart in the list
      while (currentCart.getNext() != null)
        currentCart = currentCart.getNext();
      currentCart.getPrevious().setNext(null);
      tail = currentCart.getPrevious();// change the tail to the second last one
    } else {// if it is neither the head nor the tail
      for (int i = 0; i < index; i++)
        currentCart = currentCart.getNext();// get to the aimed object
      currentCart.getPrevious().setNext(currentCart.getNext());// set the one before it to relate to
                                                               // the one after it
      currentCart.getNext().setPrevious(currentCart.getPrevious());// set the one after it to relate
                                                                   // to the one before it
    }

    size--;// size decreases one
    return originCart;// return the aimed cart

  }

  /**
   * clear the list
   * 
   * @specifiedby clear in interface SortedListADT<Cart>
   */
  @Override
  public void clear() {
    // empty the whole list by setting all to null
    while (!isEmpty())
      remove(0);
    head = null;
    tail = null;
    size = 0;

  }

  /**
   * Returns String representation of the all carts in the list
   * @override the tostring in object class
   * @return a String representation of the all carts in the list
   */
  @Override
  public String toString() {
    String string = "This list contains " + size + " cart(s)";// print out the size first
    if (size == 0) {// check if it is empty
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {// get all cargo in the list and change it to string
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;// return the result
  }

  /**
   * Returns String representation of the all carts in the order of from head to tail
   * 
   * @return a String representation of the all carts in the order of head to tail
   */
  public String readForward() {
    LinkedCart currentCart = head;
    String string = "";// initializa a empty string to store 
    for (int i = 0; i < size - 1; i++) {
      string += currentCart.getCart().getCargo();// get the cargo name of all carts
      currentCart = currentCart.getNext();
    }
    string += currentCart.getCart().getCargo();// add the last cart and its cargo
    return string;
  }

  /**
   * Returns String representation of the all carts in the order of from tail to head
   * 
   * @return a String representation of the all carts in the order of tail to head
   */
  public String readBackward() {
    LinkedCart currentCart = tail;
    String string = "";// initialize a empty string to store
    for (int i = 0; i < size - 1; i++) {
      string += currentCart.getCart().getCargo();// get the cargo from the tail of the list
      currentCart = currentCart.getPrevious();
    }
    string += currentCart.getCart().getCargo();// get the cargo of the first cart
    return string;
  }
}
