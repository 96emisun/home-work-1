package HorseRace;

import java.util.Random;

/**
 * @author Emil Sundvist
 */
public class NormalHorse extends AbstractHorse {

    private int x;
    private int y;
    private int startNbr;
    private int movement;
    private Random rdm;
    
    /**
     * The horse in this class is a normal horse. It can move anywhere between
     * 0 and 10 pixels at a time
     * 
     * @param x The x-coordinate of the horse
     * @param y The y-coordinate of the horse
     * @param startNbr The start number of the horse
     */
    public NormalHorse(int x, int y, int startNbr) {
        this.x = x;
        this.y = y;
        this.startNbr = startNbr;
        this.movement = 0;
        this.rdm = new Random();
        
    }
    
    /**
     * Moves the horse forward between 0 and 10 pixels at a time
     * 
     * @param finish The x-coordinate of the finish line
     */
    @Override
    public void forward(int finish) {
        
        movement = rdm.nextInt(11);
        MainGUI.gui.moveTo(x, y);
        x = x + movement;
        
        if(x < finish){
            MainGUI.gui.lineTo(x, y);
        }
        else{
            MainGUI.gui.lineTo(finish, y);
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
