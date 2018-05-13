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
public class CriticalBomb extends Cells implements Bomb {
    private String path;
    private final Image image = new Image (getClass().getResourceAsStream("Dynamite_SU.png")); 
    public void causeDamage()
    {
        Runner.getPlayer().s.update(-100);
        int initHealth=Runner.getPlayer().getHealth();
        if((Runner.getPlayer().immune()))
            Runner.getPlayer().setCurrentState(new VulnerableRunner());
        else
            Runner.getPlayer().h.update(-2);
    }
     @Override
    public boolean isUseful() {
        return false;
    }
    @Override
    public boolean isHarmful() {
        return true;
    }

    @Override
    public boolean isWay() {
        return true;
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
