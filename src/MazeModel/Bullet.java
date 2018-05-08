/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import java.awt.Point;
import javafx.scene.image.Image;

/**
 *
 * @author omarahmedheshamaziz
 */
public class Bullet implements Movable, Cell {
    private int dir;
    private Point position;
    private String path;
    private Image image; 
    @Override
    public boolean isHarmful() {
        return true;
    }

    @Override
    public boolean isWay() {
        return false;
    }

    @Override
    public boolean isWall() {
        return false;
    }

    @Override
    public boolean isDestructible() {
        return false;
    }

    @Override
    public void setSpriteLink(String path) {
        this.path=path;
    }

    @Override
    public String getSpriteLink() {
        return this.path;
        
    }
    

    
    @Override
    public void setDirection(int dir) {
        this.dir=dir; 
    }

    @Override
    public int getDirection() {
        return this.dir;
    }

    @Override
    public void setPosition(Point p) {
        this.position=p;
        
    }

    @Override
    public Point getPosition() {
        return this.position;
        
    }

    @Override
    public Image getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}