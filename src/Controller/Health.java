/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MazeModel.Runner;

/**
 *
 * @author MaramH
 */
public class Health implements Observer {
    public int h;

    public Health(int h) {
        this.h = h;
    }

    public void update(int h)
    {
        
        this.h+=h;
        if(this.h>3)
            this.h=3;
    }
}
