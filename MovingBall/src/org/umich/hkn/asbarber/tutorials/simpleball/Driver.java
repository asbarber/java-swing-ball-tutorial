package org.umich.hkn.asbarber.tutorials.simpleball;

import javax.swing.*;

/**
 * @author Aaron Barber, asbarber@umich.edu, March 2015
 */
public class Driver {

    public static void main(String[] args) {
        //Creates the components (ball, panel, frame)
        JFrame frame = new JFrame();
        DrawablePanel panel = new DrawablePanel();
        Ball ball = new Ball();

        //Links the components (ball to panel, panel to frame)
        panel.addBall(ball);
        frame.add(panel);

        //Finishes the frame (makes it visible)
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
