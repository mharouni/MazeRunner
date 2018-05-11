/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author omarahmedheshamaziz
 */
public class Runner extends Cells implements Movable {
     InputStream inStream = getClass().getResourceAsStream("deadpool.png");
    private String dir;
    private Point position;
    private int health=3;
    private Weapon w=new Weapon();
    private Image img = new Image(inStream);
    private static Runner Player;
    private int score=0;
    public int row;
    public int column;
   
    

    
    private Runner()
    {
        row=0;
        column=1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
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
     
    }

    @Override
    public String getSpriteLink() {
        return null;
    }

    
    public void move()
    
    {
    
        
    
    
    }
    public void keyPressed(KeyEvent e)
    {}
     public void keyReleased(KeyEvent e)
    {}

    @Override
    public void setDirection(String dir) {
    }

    @Override
    public String getDirection() {
      return null;
    }

   
    
    
}
