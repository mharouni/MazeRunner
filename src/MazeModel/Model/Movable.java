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
public interface Movable {
    public void setDirection(int dir);
    public int getDirection();
    public void setPosition(Point position);
    public Point getPosition();
    
    
    
}

