/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

import Controller.WeaponDecorator;
import javafx.scene.image.Image;

/**
 *
 * @author omarahmedheshamaziz
 */
public class AmmoGift extends WeaponDecorator implements Gift  {
    private String path;
    private Image image= new Image(getClass().getResourceAsStream("lightsabericongreen.png"));

    public AmmoGift(Runner r) {
        super(r);
    }
  /*  public void replenish()
    {
        int initAmmo=Runner.getPlayer().getW().getAmmo();
        if(initAmmo<6)
            initAmmo=6;
        Runner.getPlayer().getW().setAmmo(initAmmo);
        Runner.getPlayer().s.update(100);
        
    }*/
    
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

    @Override
    public boolean isUseful() {
        return true;
    }

    @Override
    public void replenish() {
        
    }
    
}
