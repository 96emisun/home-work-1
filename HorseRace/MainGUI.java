package HorseRace;

/**
 * @author Emil Sundqvist
 */

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

    private final JMenuBar menu;
    private final JMenu archive;
    private final JMenu about;
    private final JMenuItem exit;
    private final JMenuItem info;
    
    private final JButton btnStart;
    
    private final Point pen;
    private final Point mouse;
    
    private Race race;
    private AbstractHorse nHorse;
    private RaceResults res;
    
    private final DrawJPanel panel;

    public static MainGUI gui;

    public MainGUI(){
        
        this.gui = this;
        
        this.race = new Race();
        
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
        Creates the components of the GUI and then adds them
        */
        this.menu = new JMenuBar();
        this.archive = new JMenu("Archive");
        this.about = new JMenu("About");
        this.exit = new JMenuItem("Exit program");
        this.info = new JMenuItem("Information");
        
        this.btnStart = new JButton("Start");
        
        this.setJMenuBar(menu);
        this.menu.add(archive);
        this.menu.add(about);
        this.archive.add(exit);
        this.about.add(info);
        
        this.add(btnStart);
        
        race.drawStartLine(100, 50, 350);
        race.drawFinishLine(500, 50, 350);
        race.addHorses();
        
        /*
        Terminates the program
        */
        this.exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        /*
        Displays information about the program
        */
        this.info.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, 
                        "\u00a9 Emil Sundqvist 2014\n"
                                + "This program was created as an assignment"
                                + " for my course in programming.");
            }
        });
        
        /*
        Starts the race. The position of the horses resets each time start
        is pressed
        */
        this.btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                race.reset();
                race.startRace();
                JOptionPane.showMessageDialog(null, race.getResults());
            
            }
        });
        
        
    }

    

    /*
    Draws a line to the specified coordinates
    */
    public void lineTo(int x, int y) {
        this.panel.lineTo((int) this.pen.getX(),
                (int) this.pen.getY(), x, y);
        this.pen.move(x, y);
    }

    /*
    Moves the pen to the specified coordinates
    */
    public void moveTo(int x, int y) {
        this.pen.move(x, y);
    }

    /*
    Draws a filled circle at the specified coordinates and radius
    */
    public void drawCirc(int x, int y, int radius) {
        this.panel.drawCircle(x, y, radius);
        this.pen.move(x, y);
    }


    /*
    Writes text unto the window at the specified coordinates
    */
    public void drawString(String str, int x, int y) {
        panel.write(str, x, y);
    }

    /*
    Causes the EventWindow to pause for the given time
    */
    public void delay(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            System.out.print(
                    "We have been interrupted");
        }
        panel.repaint();
    }

    /*
    Clears the EventWindow of any drawings
    */
    public void clear() {
        this.panel.clear();
    }
    
    /*
    The following methods has the same function as the methods above, but the
    methods above these are have been created in such a way that the EventWindow
    is easy to use even for people not so experienced with Java programming
    */
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

        public void write(String str, int x, int y) {
            Graphics2D g2d = im.createGraphics();
            g2d.setColor(col);
            g2d.drawString(str, x, y);
            g2d.dispose();
            this.repaint();
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
        
       /*
        Following lines ensure that the GUI starts in EDT
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
        
        
    }

}
