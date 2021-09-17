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
// Persons:  NONE       (identify each person and describe their help in detail)
// Online Sources:  NONE (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
/**
 * create a class LinkedCart with its constructors and methods
 * 
 */
public class LinkedCart {
  private final Cart CART; // data field of this linked Cart
  private LinkedCart previous; // reference to the previous linked cart in
  // a list of carts
  private LinkedCart next; // reference to the next linked cart in a list of carts

  /**
   * Creates a new winter carnival object
   * 
   * @param cart a cart contained cargo - upper-case letter
   */
  public LinkedCart(Cart cart) {
    this.CART = cart;
    this.previous = null;
    this.next = null;
  }

  /**
   * Creates a new winter carnival object
   * 
   * @param cart     a cart contained cargo - upper-case letter
   * @param previous the linkedCart before it
   * @param next     the linkedCart after it
   */
  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }

  /**
   * Returns the cart in the linkedcart object
   * 
   * @return the cart in the object
   */
  public Cart getCart() {
    return CART;
  }

  /**
   * Returns the previous cart in the linkedcart object
   * 
   * @return the previous cart
   */
  public LinkedCart getPrevious() {
    return this.previous;
  }

  /**
   * Sets the previous cart in the linkedcart object
   * 
   * @param the previous cart
   * 
   */
  public void setPrevious(LinkedCart previous) {
    this.previous = previous;
  }

  /**
   * Return the latter cart in the linkedcart object
   * 
   * @return the latter cart
   */
  public LinkedCart getNext() {
    return this.next;
  }

  /**
   * Sets the latter cart in the linkedcart object
   * 
   * @param the latter cart
   */
  public void setNext(LinkedCart next) {
    this.next = next;
  }
}
