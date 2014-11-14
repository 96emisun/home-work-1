import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MainGUI extends JFrame{

    private JMenuBar menu;
    private JMenu archive;
    private JMenu about;
    private JMenuItem exit;
    private JMenuItem help;
    
    private JButton start;
    private JButton restart;
    private JButton addHorse;
    
    private Point pen;
    private Point mouse;
    
    private Modelclass model;
    private AbstractHorse nHorse;
    
    private DrawJPanel panel;

    public static MainGUI gui;

    public MainGUI(){
        
        this.gui = this;
        
        this.model = new Modelclass();
        
        this.setLayout(new FlowLayout( 1, 5, 5) );
        
        panel = new DrawJPanel();
        add(panel);
        
        
        this.setTitle("Horse Race");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 600, 600 );
        this.panel.setPreferredSize(new Dimension(600, 500));
        
        this.pen = new Point(0, 0);
        this.mouse = new Point(0, 0);
        
         /*
            Skapar menyerna
        */
        this.menu = new JMenuBar();
        this.archive = new JMenu("Archive");
        this.about = new JMenu("About");
        this.exit = new JMenuItem("Exit program");
        this.help = new JMenuItem("Help");
        
        this.start = new JButton("Start");
        this.restart = new JButton("Restart");
        this.addHorse = new JButton("Add Horse");
        
        this.setJMenuBar(menu);
        this.menu.add(archive);
        this.menu.add(about);
        this.archive.add(exit);
        this.about.add(help);
        
        this.add(start);
        this.add(restart);
        this.add(addHorse);
        
        model.drawStart(100, 50, 100, 300);
        
        this.exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.help.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "HELP!!!");
            }
        });
        
        this.start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(gui == null){
                    System.out.println("Tom");
                }
                model.startRace();
            
            }
        });
        
        this.addHorse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                model.addNormalHorse();
                
            }
        });
        
        
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
     * @param icon The icon.
     * @param x X-coordinate for the image. 
     * @param y Y-coordinate for the image.
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
    
    private class DrawJPanel extends JPanel {

        private Color col;
        private float strokeWidth;
        private BufferedImage im;

        public DrawJPanel() {
            super();

            this.col = Color.BLACK;
            this.im = new BufferedImage(600, 400,
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
    
    public static void main(String[] args ) {
        
        //Following lines ensure that the GUI starts in EDT
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
        
        
    }

}
