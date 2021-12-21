/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_3;
import java.util.Comparator;
/**
 *
 * @author Admin
 */
public class DefaultComparator <E> implements Comparator<E> {
  public int compare(E a,E b) throws ClassCastException{
      return ((Comparable <E>) a).compareTo(b);
  }    
}
