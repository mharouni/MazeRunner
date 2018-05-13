/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MazeModel.Runner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author MaramH
 */
public class TimerThread extends Thread {
    public int i=0;
   public void run()
   {
       TimerTask gameTime;
       Timer timer = new Timer();
       gameTime = new TimerTask(){
           public void run()
           {
               
               
               TimerTask task = new TimerTask(){
                   @Override
                   public void run() {
                       i++;
                   }
               };
           }
       };
       
       
       timer.schedule(gameTime, 0 , 1000);
     
   }
    
}
