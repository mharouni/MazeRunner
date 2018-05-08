/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import java.awt.Point;
import java.awt.event.KeyEvent;
import javafx.scene.image.Image;

/**
 *
 * @author omarahmedheshamaziz
 */
public class Runner extends Cells implements Movable {
    private int dir;
    private Point position;
    private int health=3;
    private Weapon w=new Weapon();
    private Image img = new Image("file:/C:/Users/MaramH/Desktop/Sprites/deadpool.png");;
    private static Runner Player;
    private int score=0;
    private Runner()
    {
        
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getW() {
        return w;
    }

    public void setW(Weapon w) {
        this.w = w;
    }
    public static Runner getPlayer()
    {
        if(Player==null)
            Player=new Runner();
        return Player;
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
    public boolean isHarmful() {
        return false;
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

    public Image getImage() {
        return img;
    }

    public void setImage(Image image) {
        this.img = image;
    }

    @Override
    public void setSpriteLink(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSpriteLink() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void move()
    
    {
    
        
    
    
    }
    public void keyPressed(KeyEvent e)
    {}
     public void keyReleased(KeyEvent e)
    {}
    
    
}
