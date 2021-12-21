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
public class partA_Driver {
    
    public static void main(String[]args){
        LinkedBinaryTree <String> tree= new LinkedBinaryTree();
        
        Scanner kb= new Scanner(System.in);
       Position <String> root=tree.addRoot("do you have enough savings?");
       
       Position <String> left1=tree.addLeft(root, "do you want to invest it?");
       Position <String> right1 = tree.addRight(root,"do you have job to earn some money ?");
       
       tree.addLeft(left1,"try investing it in bit-coin");
       tree.addRight(left1,"then use it for retirement ");
       
       tree.addLeft(right1,"then save some money from your salary!");
       tree.addRight(right1,"then find a job to earn money!");
      
       Position <String> cursor= root;
       System.out.println(cursor);
       while(!tree.isExternal(cursor)){          
                
          String input = kb.next();
          
          if(input.equals("yes")){
              System.out.println(tree.left(cursor));
              cursor=tree.left(cursor);
  
          }
          else if (input.equals("no")){
              System.out.println(tree.right(cursor));
              cursor=tree.right(cursor);
          }
               
              }
       
    }
            
    
    
    
}
