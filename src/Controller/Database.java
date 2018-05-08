/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MaramH
 */
public class Database {
    
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
}
        
    

