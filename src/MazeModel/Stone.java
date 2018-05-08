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
public class Stone implements Wall {
    Image image = new Image("file:/C:/Users/MaramH/Desktop/Sprites/Sprite_BB.png");
    
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
        return true;
    }

    @Override
    public boolean isDestructible() {
        return false;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void setSpriteLink(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSpriteLink() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
