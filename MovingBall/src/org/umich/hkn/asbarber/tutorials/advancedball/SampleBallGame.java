package org.umich.hkn.asbarber.tutorials.advancedball;

import java.awt.Color;

/**
 * @author Aaron Barber, asbarber@umich.edu, March 2015
 */
public class SampleBallGame {
    
    public static void main(String[] args) {
        //Creates a window
        VisualWindow myWindow = new VisualWindow("Fun Game!");
        myWindow.sizeTo(600, 400);
        myWindow.moveTo(100, 100);
        
        //Creates a ball
        Ball myBall = new Ball();
        myBall.setColor(Color.BLUE);
        
        //Adds the ball to the window
        myWindow.addItem(myBall);
        
        //Add a lot of balls
        for (int i = 0; i < 5; i++){
            myWindow.addItem(new Ball());
        }
        
        //Starts updating
        myWindow.setRefreshRate(5);   //Redraw/move items every 100 milliseconds
        myWindow.start();
    }
}
