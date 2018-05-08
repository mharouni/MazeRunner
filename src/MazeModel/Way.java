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
public class Way implements Cell {
    private Image image;
    String path;
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
