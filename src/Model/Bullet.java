/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;

/**
 *
 * @author MaramH
 */
public class Bullet implements Movable{

    protected int direction;
    protected Point position;
    @Override
    public void setDirection(int dir) {
       this.direction = dir;
      
    }

    @Override
    public int getDirection() {
    return this.direction;
    }

    @Override
    public void setPosition(Point position) {
    this.position = position;
    }

    @Override
    public Point getPosition() {
       return this.position;
    }
    
}

