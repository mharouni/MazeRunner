/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeModel;

/**
 *
 * @author omarahmedheshamaziz
 */
public class Weapon {

    public Weapon() {
        ammo =6;
    }
    private int ammo;
    Bullet b;

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public Bullet getB() {
        return b;
    }

    public void setB(Bullet b) {
        this.b = b;
    }
    
}
