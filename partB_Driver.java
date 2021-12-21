/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_3;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class partB_Driver {
    
    public static void main(String [] args){
        System.out.println("welcom to the hospital");
        LinkedHeapPriorityQueue<Integer, String> LHPQ = new LinkedHeapPriorityQueue();
        boolean exit=true;
        
       
        
        while(exit){
        System.out.println("choose the number: \n 1).add patient \n 2).call next patient in \n 3).list of the patients \n4). see who is next\n 5).exit");
        
        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();
        
        switch(input){
            case 1: System.out.println("enter priority and the name");
                    LHPQ.insert(kb.nextInt(),kb.next());
                    System.out.println("patient has been added");
                    break;
            case 2: System.out.println("your turn now"+LHPQ.removeMin());
                    break;
            case 3: System.out.println(LHPQ);
                     break;
            case 4:  System.out.println(LHPQ.min());
                     break;
            case 5:  exit=false;
                      break;
        }
        
        }
    }
}
