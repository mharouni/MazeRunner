/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MazeModel.Runner;
import MazeModel.Weapon;

/**
 *
 * @author MaramH
 */
public abstract class WeaponDecorator implements Gun{
    protected Runner runner;

    public WeaponDecorator(Runner r) {
        this.runner = r;
    }

    @Override
    public void Reload() {
        this.runner.setW(new Weapon());
    }
    @Override
    public void destroy()
    {
        if (this.runner.getW().getAmmo() == 0 )
            this.runner.setW(null);
    }
    
    
}
