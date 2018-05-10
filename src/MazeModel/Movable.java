/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import java.awt.Point;

/**
 *
 * @author omarahmedheshamaziz
 */
public interface Movable {
    public void setDirection(String dir);
    
    public String getDirection();
    
    public void setPosition(Point p);
    
    public Point getPosition();
    
    
    
    
}
