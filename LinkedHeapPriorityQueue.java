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
public class LinkedHeapPriorityQueue <K,V> extends AbstractPriorityQueue <K,V>{
    
    protected LinkedBinaryTree <Entry<K,V>> Heap;
    
    public LinkedHeapPriorityQueue(){
         super();
         Heap = new LinkedBinaryTree ();
        
    }
    
    
    public LinkedHeapPriorityQueue(Comparator<K> comp){
        super(comp);
    }
    
    protected void swap(Position <Entry<K,V>> p1, Position <Entry<K,V>> p2){
       Entry<K,V> temp =  Heap.set(p1,p2.getElement());
      
       Heap.set(p2,temp);
      
               
    }
    protected void upheap(Position<Entry<K,V>> entry){
        
        
        
        while(compare(entry.getElement(),Heap.root().getElement())>=0){
            Position <Entry<K,V>> parent = Heap.parent(entry);
                if(compare(entry.getElement(),parent.getElement())>=0)
                     break;
                swap(parent,entry);
                entry=parent;
        }
        
    }
    
    protected void downheap(Position<Entry<K,V>> down){
        while(Heap.isInternal(down)){
            Position <Entry<K,V>> child;
            int rightOrLeft=0;
            if(Heap.numChildren(down)==2){
        if(compare(Heap.left(down).getElement(),Heap.right(down).getElement())<0){
           child = Heap.left(down);
           rightOrLeft=1;
    } 
        else{
             child = Heap.right(down);
             rightOrLeft=2;
        }
            }
            else {
                child=Heap.left(down);
            }
        
        if(compare(child.getElement(),down.getElement())>=0)
            break;
            
        swap(child,down);
           if(rightOrLeft==1){
            down=Heap.left(down);
    }
        else{
             down = Heap.right(down);
        }
        
        }  
        
    }
    
    public int size(){
        return Heap.size();
    }
    
    public Entry<K,V> min(){
        if(Heap.isEmpty())
            return null;
        return Heap.root().getElement();
    }
    
    public Entry<K,V> insert (K key,V value) throws IllegalArgumentException{
        checkKey(key);
        Entry<K,V> newest = new PQEntry(key,value);
        if(Heap.size()==0){
            Heap.addRoot(newest);
            return newest;
        }
        
         if(Heap.size()>0){
          Position <Entry<K,V>> parent= Heap.root;
          for(Position<Entry<K,V>> c : Heap.positions()){
              if(Heap.numChildren(c)<2){
                  parent=c;
                  break;
              }
          }
          if(Heap.numChildren(parent)==1){
              Heap.addRight(parent, newest);
              upheap(Heap.right(parent));
          }
          else
          {
              Heap.addLeft(parent, newest);
              upheap(Heap.left(parent));
          }
         }
         
         
        
                
          return newest;
    }
    
   
    public Entry<K,V> removeMin(){
        if(Heap.isEmpty())
            return null;
        
        Position <Entry<K,V>> last=Heap.root;
        int index=0;
            for(Position<Entry<K,V>> c: Heap.positions()){
                index++;
                if(index==Heap.size()){
                     last=c;
                }
            }
        swap(Heap.root,last);
       
       Entry<K,V> answer= Heap.remove(last);
        downheap(Heap.root);
       return answer;
       }
    
    
    public String toString(){
        String str="";
        
        for(Position<Entry<K,V>> c: Heap.positions())
          str=str+c+" ";
        
        return str;
    } 
}
