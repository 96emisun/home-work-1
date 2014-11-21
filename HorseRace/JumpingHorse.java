package HorseRace;

import java.util.Random;

/**
 * @author Emil Sundqvist
 */
public class JumpingHorse extends AbstractHorse {

    private int x;
    private int y;
    private int startNbr;
    private int movement;
    private Random rdm;
    
    /**
     * The horse in this class is a jumping horse. It can move anywhere between
     * 0 and 6 pixels at a time. If it moves 0 pixels, it makes a 15-pixel
     * jump instead
     * 
     * @param x The x-coordinate of the horse
     * @param y The y-coordinate of the horse
     * @param startNbr The start number of the horse
     */
    public JumpingHorse(int x, int y, int startNbr) {
        this.x = x;
        this.y = y;
        this.startNbr = startNbr;
        this.movement = 0;
        this.rdm = new Random();
        
    }

    /**
     * Moves the horse forward between 0 and 6 pixels at a time. If it 
     * moves 0 pixels it makes a 15-pixel jump instead
     * 
     * @param finish The x-coordinate of the finish line
     */
    @Override
    public void forward(int finish) {
        
        movement = rdm.nextInt(7);
        if(movement == 0){
            
            movement = 15;
            MainGUI.gui.moveTo(x, y);
            x = x + movement;
            
        }
        else{
            
            MainGUI.gui.moveTo(x, y);
            x = x + movement;

            if(x < finish){
                MainGUI.gui.lineTo(x, y);
            }
            else{
                MainGUI.gui.lineTo(finish, y);
            }
            
        }
        
        
    }
    
    /**
     * 
     * @return Returns the x-coordinate of the horse
     */
    @Override
    public int getX(){
        return x;
    }
    
    /**
     * Sets the x-coordinate of the horse to the specified value
     * 
     * @param x The specified x-coordinate
     */
    @Override
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * 
     * @return Returns the start number of the horse
     */
    @Override
    public int getStartNbr(){
        return startNbr;
    }
    
    /**
     * Compares this horse with another horse and returns a value based on it's
     * current x-coordinate
     * 
     * @param other The horse to compare this horse with
     * @return Returns 1 if this horse is ahead of other, 0 if equal and -1
     * if behind
     */
    @Override
    public int compareTo(AbstractHorse other) {
        
        if(this.x < other.getX()){
            return -1;
        }
        
        else if(this.x == other.getX()){
            return 0;
        }
        
        else if(this.x > other.getX()){
            return 1;
        }
        
        else{
            return 0;
        }
    }


}
