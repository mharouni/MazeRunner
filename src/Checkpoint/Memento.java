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
public class Memento {
    private int[][] array = new int[30][30];

public Memento(int[][] arr)
{
    //this.array=(ArrayList<AbstractShape>)arr.clone();
    for (int i = 0; i<30;i++)
    {
         for (int j = 0; j<30;j++)
    {
       this.array[i][j]=arr[i][j];
        
    }
    }
}

    public int[][] getArray() {
        return array;
    }

}
