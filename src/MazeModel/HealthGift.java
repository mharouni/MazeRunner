/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import javafx.scene.image.Image;

/**
 *
 * @author omarahmedheshamaziz
 */
public class HealthGift extends Cells  implements Gift {
    
    private String path;
    private Image image= new Image(getClass().getResourceAsStream("heart.png")); 
    public void replenish()
    {
        int initHealth = Runner.getPlayer().getHealth();
        initHealth++;
        Runner.getPlayer().setHealth(initHealth);
                
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
        return true;
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
    public Image getImage() {
    return image;
    }
}
