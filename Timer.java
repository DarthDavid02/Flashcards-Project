/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author donov
 */
public class Timer {
    private int timerLength;
    private Thread t;
    public Timer(int max)
    {
        timerLength = max;
    }
    
    public void timer(JProgressBar time, FlashCards window, ArrayList <Cards> list)
    {
       time.setMaximum(timerLength);
       //long start = System.currentTimeMillis();
       t = new Thread (new Runnable () {
       @Override
       public void run()
       {
           for(int i = time.getMaximum(); i > 0 ; i--)
           {
               if(!window.isFlipped)
               {
                   time.setValue(i-1);
                   try {
                   Thread.sleep(1000);
                   } catch (InterruptedException ex) {
                   Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else
               {
                  break;
               }
               
           }
           if(!window.isFlipped)
           {
                //long stop = System.currentTimeMillis();
                //int timePassed = ((int) stop - (int) start)/1000;
                //System.out.println("Finished in " + timePassed + " seconds");
                window.showCard(1, list.get(window.getCardCount()));
                window.isFlipped = true;
                window.getPrev().setEnabled(true);
                window.getNext().setEnabled(true);
           }
             
       }
       });
       t.start();       
    }

}
