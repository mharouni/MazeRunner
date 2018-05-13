/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MazeModel.*;

/**
 *
 * @author MaramH
 */
public class Interactions {
    public boolean checkBombs(Cell x)
    {
        if(x.isHarmful()){
            ((Bomb)x).causeDamage();
            return true;}
        return false;
    }
    
    public boolean checkGift(Cell x)
    {
        if(x.isUseful())
        {   
         ((Gift)x).replenish();
         AmmoGift  r= new AmmoGift(Runner.getPlayer());
         r.Reload();
            return true;
        }
        return false;
        
    }
    public boolean checkDead()
    {
        if (Runner.getPlayer().h.h==0)
            return true;
        else return false;
    }
}
