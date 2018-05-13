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
public class CoinGift extends Cells implements Gift  {
    private String path;
    private Image image ; 
    public void replenish()
    {
        int initScore= Runner.getPlayer().getScore();
        initScore+=5;
        Runner.getPlayer().setScore(initScore);
                int s = Runner.getPlayer().getScore();
        s+=50;
        Runner.getPlayer().setScore(s);
    }
    @Override
    public boolean isUseful() {
        return true;
    }
    
    @Override
    public boolean isHarmful() {
        return false;
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
    public Image getImage() {
       return image;
    }
    
}
