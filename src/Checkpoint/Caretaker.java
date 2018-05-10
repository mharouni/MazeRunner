/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkpoint;

import java.util.ArrayList;

/**
 *
 * @author MaramH
 */
public class Caretaker {
    public ArrayList<Memento> savedState= new ArrayList<>();

  
   
   
   public void addMemento(Memento m)
   {
       savedState.add(m);
   }
   public Memento getMemento(int index) 
   { 
       return savedState.get(index);
   }
    
}
