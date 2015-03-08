package org.umich.hkn.asbarber.tutorials.advancedball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * @author Aaron Barber, asbarber@umich.edu, March 2015
 */
public class Ball implements Drawable {

    //Ball data
    //--------------------------------------------------------------------------
    //Location, Speed, and other Physics information
    private int x_position;
    private int y_position;
    private int x_velocity;
    private int y_velocity;
    private Rectangle boundary;

    //Visual information
    private Color color;
    private int radius;
    //--------------------------------------------------------------------------

    //Create a ball
    //--------------------------------------------------------------------------
    public Ball() {
        this(0, 0, randomColor());
        setVelocity(randomVelocity(), randomVelocity());
    }

    public Ball(int x, int y, Color color) {
        x_position = x;
        y_position = y;

        x_velocity = 4;
        y_velocity = 4;

        this.boundary = null;

        this.color = color;
        this.radius = 10;
    }
    //--------------------------------------------------------------------------

    //Modify the ball
    //--------------------------------------------------------------------------
    public void setColor(Color c) {
        color = c;
    }

    public void setRadius(int r) {
        radius = r;
    }

    public void setLocation(int x, int y) {
        x_position = x;
        y_position = y;
    }

    public final void setVelocity(int dx, int dy) {
        x_velocity = dx;
        y_velocity = dy;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }
    //--------------------------------------------------------------------------

    //Move and draw the ball
    //--------------------------------------------------------------------------
    public void move() {
        //Change position
        x_position += x_velocity;
        y_position += y_velocity;

        //This is the logic to make the ball bounce:
        //When there is a boundary, make sure the ball is inside it
        if (boundary != null) {
            //X is too high
            if (x_position + 2*radius >= boundary.getMaxX()) {
                x_velocity *= -1;
            }
            //X is too low
            if (x_position <= boundary.getMinX()) {
                x_velocity *= -1;
            }

            //Y is too high
            if (y_position + 2*radius >= boundary.getMaxY()) {
                y_velocity *= -1;
            }
            //Y is too low
            if (y_position <= boundary.getMinY()) {
                y_velocity *= -1;
            }

        }
    }

    @Override
    public void draw(Graphics g) {
        move();

        g.setColor(color);
        g.fillOval(x_position, y_position, radius, radius);
    }
    //--------------------------------------------------------------------------

    private static Color randomColor() {
        Random rand = new Random();
        return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    private static int randomVelocity() {
        return new Random().nextInt(5) + 1;
    }
}
