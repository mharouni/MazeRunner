/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Checkpoint.Caretaker;
import Checkpoint.Memento;
import Checkpoint.Originator;
import MazeModel.Runner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MaramH
 */
public class Database {
    Originator o = new Originator();
    Caretaker care= new Caretaker();
    public int[][] readInit()
    {   int[][] matrix = new int[30][30];
        try {
            Scanner scanner= new Scanner(new File("Maze_File"));
            for(int i=0;i<30;i++)
            {
                for(int j=0;j<30;j++)
                {
                    matrix[i][j]=scanner.nextInt();
                    System.out.printf("%d ",matrix[i][j]);
                }
                System.out.println();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matrix;
    }
    
    public void save(int[][] array)
    {
       o.setMatrix(array);
       care.addMemento(o.createMemento());
        try {
            
            PrintWriter out = new PrintWriter(new File("CheckPoint_File"));
            for(int x=0; x<30; x++)
            {   for(int y=0;y<30;y++)
                    {
                        out.printf("%d ",(care.savedState.get(care.savedState.size()-1).getArray())[x][y]);
                        
                        System.out.print(array[x][y]);
                    }
                out.println();
                System.out.println();
            }
            out.printf("%d %d ", Runner.getPlayer().row , Runner.getPlayer().column);
            out.printf("%d %d",Runner.getPlayer().h.h,Runner.getPlayer().s.score);
            
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    public int[][] load()
    {
         int[][] matrix = new int[30][30];
        try {
            Scanner scanner= new Scanner(new File("CheckPoint_File"));
            for(int i=0;i<30;i++)
            {
                for(int j=0;j<30;j++)
                {
                    matrix[i][j]=scanner.nextInt();
                    System.out.printf("%d ",matrix[i][j]);
                }
                System.out.println();
            }
            Runner.getPlayer().row = scanner.nextInt();
            Runner.getPlayer().column = scanner.nextInt();
            Runner.getPlayer().h.h=scanner.nextInt();
            Runner.getPlayer().s.score=scanner.nextInt();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matrix;
    }
}
        
    

