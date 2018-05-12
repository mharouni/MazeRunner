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
public class Originator {
    private int[][] array = new int[30][30];

    public void setMatrix(int[][] array) {
        this.array=array;
    }
    public Memento createMemento()
    {
        System.out.println("originator created a memento");
        return new Memento(array);
    }
    public int[][] returnMemento(Memento memento)
            
    {
        System.out.println("Originator retrieved a memento");
        return memento.getArray();
    }
    
}
