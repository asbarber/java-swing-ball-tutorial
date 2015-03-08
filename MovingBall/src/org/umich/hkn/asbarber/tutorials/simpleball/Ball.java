package org.umich.hkn.asbarber.tutorials.simpleball;

import java.awt.Graphics;

/**
 * @author Aaron Barber, asbarber@umich.edu, March 2015
 */
public class Ball {

    private int x = 0, y = 0;
    private int dx = 2, dy = 2;
    private int radius = 10;

    public void draw(Graphics g) {
        x += dx;
        y += dy;

        g.drawOval(x, y, radius, radius);
    }
}
