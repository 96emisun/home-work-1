package EventWindow;

/*
 * Author: Stefan Sollander
 * Created: 2013-09-28
 * Last modified: 2013-10-13
 */

import javax.swing.*;

import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The class EventWindow creates a JFrame and a JPanel for some basic drawing
 * methods. In addition the window listens to mouse-clicks and some key-presses
 * and can return the coordinates of the click and type of key.
 *
 * @author Stefan Sollander
 * @version 1.5
 *
 */
@SuppressWarnings("serial")
public final class EventWindow extends JFrame {

    protected DrawJPanel panel;
    protected int height;
    protected int width;
    protected String name;
    protected Point pen;
    protected Point mouse;
    protected int key;

    /**
     * The class constructor. Creates a EventWindow with the specified width,
     * height and name.
     *
     * @param width Width of the window.
     * @param height Height of the window.
     * @param name The title of the window.
     */
    public EventWindow(int width, int height, String name) {

        this.setLayout(new BorderLayout());

        this.height = height;
        this.width = width;
        this.name = name;

        this.pen = new Point(0, 0);
        this.mouse = new Point(0, 0);

        this.setSize(width, height);
        this.setLocation(100, 100);
        this.setTitle(name);
        this.panel = new DrawJPanel();
        this.panel.setPreferredSize(new Dimension(width, height));

        this.panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventWindow.this.mouse = e.getPoint();
            }
        });
        this.panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                EventWindow.this.key = e.getKeyCode();
            }
        });

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    /**
     * Returns the height of the EventWindow.
     *
     * @return Height of the window.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the EventWindow.
     *
     * @return Width of the window.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the pens current x-coordinate.
     *
     * @return The pens current x-coordinate.
     */
    public int getPenX() {
        return (int) this.pen.getX();
    }

    /**
     * Returns the pens current y-coordinate.
     *
     * @return The pens current y-coordinate.
     */
    public int getPenY() {
        return (int) this.pen.getY();
    }

    /**
     * Returns the mouse current x-coordinate.
     *
     * @return The mouse current x-coordinate.
     */
    public int getMouseX() {
        return (int) this.mouse.getX();
    }

    /**
     * Returns the mouse current y-coordinate.
     *
     * @return The mouse current y-coordinate.
     */
    public int getMouseY() {
        return (int) this.mouse.getY();
    }

    /**
     * Depending on which key were last pressed the method returns a different
     * integer.
     *
     * @return	UP returns 1, DOWN returns 2, LEFT returns 3, RIGHT returns 4 and
     * SPACE returns 5. W returns 6, S returns 7, A returns 8, D returns 9. No
     * key pressed returns -1.
     */
    public int getKey() {
        switch (this.key) {
            case KeyEvent.VK_UP:
                this.key = 0;
                return 1;
            case KeyEvent.VK_DOWN:
                this.key = 0;
                return 2;
            case KeyEvent.VK_LEFT:
                this.key = 0;
                return 3;
            case KeyEvent.VK_RIGHT:
                this.key = 0;
                return 4;
            case KeyEvent.VK_SPACE:
                this.key = 0;
                return 5;
            case KeyEvent.VK_W:
                this.key = 0;
                return 6;
            case KeyEvent.VK_S:
                this.key = 0;
                return 7;
            case KeyEvent.VK_A:
                this.key = 0;
                return 8;
            case KeyEvent.VK_D:
                this.key = 0;
                return 9;
            default:
                return -1;
        }
    }

    /**
     * Draws a line to the specified coordinates.
     *
     * @param x The specified x-coordinate.
     * @param y The specified y-coordinate.
     */
    public void lineTo(int x, int y) {
        this.panel.lineTo((int) this.pen.getX(),
                (int) this.pen.getY(), x, y);
        this.pen.move(x, y);
    }

    /**
     * Changes the pen to the specified width.
     *
     * @param width The specified color.
     */
    public void setLineWidth(int width) {
        this.panel.setLineWidth(width);
    }

    /**
     * Changes the pen to the specified color.
     *
     * @param col The specified color.
     */
    public void setColor(Color col) {
        this.panel.setColor(col);
    }

    /**
     * Moves the pen to the specified coordinates.
     *
     * @param x The specified x-coordinate.
     * @param y The specified y-coordinate.
     */
    public void moveTo(int x, int y) {
        this.pen.move(x, y);
    }

    /**
     * Draws a filled circle at the specified coordinates and radius.
     *
     * @param x The specified x-coordinate.
     * @param y The specified y-coordinate.
     * @param radius The specified radius of the circle.
     */
    public void drawCirc(int x, int y, int radius) {
        this.panel.drawCircle(x, y, radius);
        this.pen.move(x, y);
    }

    /**
     * Draws a filled rectangle at the specified coordinates with the specified
     * dimensions.
     *
     * @param x The specified x-coordinate.
     * @param y The specified y-coordinate.
     * @param a Width of the rectangle.
     * @param b Height of the rectangle.
     *
     */
    public void drawRect(int x, int y, int a, int b) {
        this.panel.drawRect(x, y, a, b);
        this.pen.move(x, y);
    }

    /**
     * Draws an image at the specified coordinates.
     */
    public void drawImage(ImageIcon icon, int x, int y) {
        panel.drawImage(icon, x, y);
    }

    /**
     * Writes text unto the window at the specified coordinates.
     *
     * @param	str	String to write.
     * @param	x	X-coordinate for the text.
     * @param	y	Y-coordinate for the text.
     */
    public void drawString(String str, int x, int y) {
        panel.write(str, x, y);
    }

    /**
     * Causes the EventWindow to pause for the given time.
     *
     * @param millisec The specified time in milliseconds the EventWindow
     * pauses.
     */
    public void delay(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            System.out.print(
                    "We have been interrupted");
        }
    }

    /**
     * Clears the EventWindow of any drawings.
     *
     */
    public void clear() {
        this.panel.clear();
    }

    /**
     * Causes the EventWindow to wait for a mouse-click.
     */
    public void waitForMouse() {
        this.mouse = null;
        while (mouse == null) {
            this.delay(50);
        }
    }

    /**
     * Causes the EventWindow to wait for a key-press.
     */
    public void waitForKey() {
        this.key = 0;
        this.panel.setFocusable(true);
        this.panel.requestFocusInWindow();
        while (key == 0) {
            this.delay(50);
        }
    }

    /**
     * DrawJPanel class is the drawing board for the EventWindow.
     *
     *
     */
    private class DrawJPanel extends JPanel {

        protected Color col;
        protected float strokeWidth;
        protected BufferedImage im;

        public DrawJPanel() {
            super();

            this.col = Color.BLACK;
            this.im = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = im.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, im.getWidth(null), im.getHeight(null));
            g2d.dispose();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(im, 0, 0, this);
        }

        public void lineTo(int x1, int y1, int x2, int y2) {
            Graphics2D g2d = im.createGraphics();
            BasicStroke bs = new BasicStroke(strokeWidth);
            g2d.setStroke(bs);
            g2d.setColor(col);
            g2d.drawLine(x1, y1, x2, y2);
            g2d.dispose();
            this.repaint();
        }

        public void drawCircle(int x, int y, int radius) {
            Graphics2D g2d = im.createGraphics();
            BasicStroke bs = new BasicStroke(strokeWidth);
            g2d.setStroke(bs);
            g2d.setColor(col);
            g2d.fillOval(x, y, radius, radius);
            g2d.dispose();
            this.repaint();
        }

        public void drawRect(int x, int y, int a, int b) {
            Graphics2D g2d = im.createGraphics();
            BasicStroke bs = new BasicStroke(strokeWidth);
            g2d.setStroke(bs);
            g2d.setColor(col);
            g2d.fillRect(x, y, a, b);
            g2d.dispose();
            this.repaint();
        }

        public void write(String str, int x, int y) {
            Graphics2D g2d = im.createGraphics();
            g2d.setColor(col);
            g2d.drawString(str, x, y);
            g2d.dispose();
            this.repaint();
        }

        public void drawImage(ImageIcon icon, int x, int y) {
            Graphics2D g2d = im.createGraphics();
            icon.paintIcon(this, g2d, x, y);
            g2d.dispose();
            this.repaint();
        }

        public void setLineWidth(int stroke) {
            this.strokeWidth = stroke;
        }

        public void setColor(Color col) {
            this.col = col;
        }

        public void clear() {

            Graphics2D g2d = im.createGraphics();

            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, im.getWidth(null), im.getHeight(null));
            g2d.dispose();
            this.repaint();
        }
    }
}
