/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import java.awt.Point;
import java.io.InputStream;
import javafx.scene.image.Image;

/**
 *
 * @author omarahmedheshamaziz
 */
public class Bullet extends Cells implements Movable{
    private String dir;
    private Point position;
     InputStream inStream = getClass().getResourceAsStream("new_bullet.png");
    private String path;
    public int row;
    public int column;
    private Image image= new Image(inStream); 
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
    public void setDirection(String dir) {
        this.dir=dir; 
    }

    @Override
    public String getDirection() {
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
        return this.image;
    }
    
    
    
}