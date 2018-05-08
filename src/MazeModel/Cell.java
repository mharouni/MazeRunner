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
public interface Cell {
    public boolean isHarmful();
    
    public boolean isWay();
    
    public boolean isWall();
    
    public boolean isDestructible();
    
    public void setSpriteLink(String path);
    
    public String getSpriteLink();
    
    public Image getImage();
    
    
    
}
