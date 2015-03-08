package org.umich.hkn.asbarber.tutorials.simpleball;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * @author Aaron Barber, asbarber@umich.edu, March 2015
 */
public class DrawablePanel extends JPanel {

    //Balls that we will draw
    private List<Ball> items = new ArrayList<>();

    //Starts a thread to continously draw the balls
    public DrawablePanel(){
        new Thread() {
            @Override
            public void run() {
                //Repaints every 100 ms
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        //Please handle me!
                        System.exit(1);
                    }
                }
            }
        }.start();        
    }
    
    //Tracks a new ball to be drawn!
    public void addBall(Ball b) {
        items.add(b);
    }

    //Actually draws the balls we are tracking
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Ball item : items) {
            item.draw(g);
        }
    }
}
