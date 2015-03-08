package org.umich.hkn.asbarber.tutorials.advancedball;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Aaron Barber, asbarber@umich.edu, March 2015
 */
public class VisualWindow {

    private final JFrame frame;
    private final JPanel panel;
    private final List<Drawable> items;
    private int refresh_rate = 100;

    public VisualWindow(String title) {
        //Creates components
        frame = new JFrame(title);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Drawable item : items) {
                    item.draw(g);
                }
            }
        };
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                if (items != null) {
                    for (Drawable item : items) {
                        if (item instanceof Ball) {
                            ((Ball) item).setBoundary(new Rectangle(0, 0, panel.getWidth(), panel.getHeight()));
                        }
                    }
                }
            }
        });

        //Adds components
        frame.add(panel);

        //Finalizes components
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Data
        items = new ArrayList<>();
    }

    //Window Control
    //--------------------------------------------------------------------------
    public void moveTo(int width, int height) {
        frame.setLocation(width, height);
    }

    public void sizeTo(int width, int height) {
        frame.setPreferredSize(new Dimension(width, height));
        frame.pack();
    }
    //--------------------------------------------------------------------------

    //Making things move
    //--------------------------------------------------------------------------
    public void start() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    panel.repaint();
                    try {
                        Thread.sleep(refresh_rate);
                    } catch (InterruptedException ex) {
                        System.out.println("Uh-oh, unable to pause rendering!");
                        Logger.getLogger(VisualWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }

    public void setRefreshRate(int refresh_rate) {
        this.refresh_rate = refresh_rate;
    }
    //--------------------------------------------------------------------------

    //Adding to the Window
    //--------------------------------------------------------------------------    
    public void addItem(Drawable item) {
        items.add(item);

        if (item instanceof Ball) {
            ((Ball) item).setBoundary(new Rectangle(0, 0, panel.getWidth(), panel.getHeight()));
        }
    }
    //--------------------------------------------------------------------------

    //Advanced
    //--------------------------------------------------------------------------   
    public JFrame getFrame() {
        return frame;
    }
    //--------------------------------------------------------------------------
}
