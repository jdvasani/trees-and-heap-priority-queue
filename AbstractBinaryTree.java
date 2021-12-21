/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_3;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public abstract class AbstractBinaryTree <E> extends AbstractTree <E> implements BinaryTree <E>{
    
    public Position <E> sibling (Position <E> p){
        Position <E> parent= parent(p);
        if(parent==null) return null;
        if(p==left(parent))
            return right(parent);
        else
            return left(parent);
    }
    
    public int numChildren (Position <E> p) {
        int count=0;
        if(left(p) !=null)
            count++;
        if(right(p)!= null)
            count++;
        return count;
    }
    
    public Iterable <Position <E>> children(Position <E> p){
        List <Position <E>> snapshot = new ArrayList<> (2);
        if(left(p)!=null)
            snapshot.add(left(p));
        if(right(p)!=null)
            snapshot.add(right(p));
        
        return snapshot;
    }
}
