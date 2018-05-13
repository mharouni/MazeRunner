/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MazeModel.AmmoGift;
import MazeModel.ArmorGift;
import MazeModel.Bullet;
import MazeModel.Cell;
import MazeModel.CoinGift;
import MazeModel.CriticalBomb;
import MazeModel.Gate;
import MazeModel.HealthGift;
import MazeModel.MildBomb;
import MazeModel.Runner;
import MazeModel.Stone;
import MazeModel.Tree;
import MazeModel.Way;
import javafx.scene.Node;

/**
 *
 * @author omarahmedheshamaziz
 */
public class CellFactory {
    
    public Cell[][] mazeFactory(int[][] layout)
    {
        Cell[][] maze = new Cell[30][30];
        for(int i=0; i<30; i++)
        {
            for(int j=0; j<30; j++)
            {
                maze[i][j]=cellFactory(layout[i][j]);
            }
        }
        return maze;
    } 
    
    public Cell cellFactory(int x)
    {
        if(x==0)
            return new Way();
        else if(x==1)
            return new Stone();
        else if(x==2)
            return new Tree();
        else if(x==3)
            return new CriticalBomb();
        else if(x==4)
            return new AmmoGift();
        else if(x==5)
            return new CoinGift();
        else if(x==6)
            return new HealthGift();
        else if(x==7)
            return new ArmorGift();
        else if(x==8)
            return new Bullet();
        else if(x==9)
            return new MildBomb();
        else if(x=='A')
            return new CriticalBomb();
        else
            return new Gate();
    }
    
    public int reverseFactory(Node n)
    {
        return 0;
       // if(n.equals(Tree))
    }
    
}
