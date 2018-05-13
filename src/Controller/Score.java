/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author MaramH
 */
public class Score implements Observer {
        public int score;
    public Score(int i) {
        score=i;
    }
    
    public void update(int score)
    {
        
        this.score+=score;
        if(this.score<0)
            this.score=0;
            
    }
    
}
