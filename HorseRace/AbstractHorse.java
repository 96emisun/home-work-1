package HorseRace;

/** 
 * @author Emil Sundqvist
 */
public abstract class AbstractHorse implements Comparable {
    private int x;
    private int y;
    private int startNbr;
    
    /**
     * This is an abstract class that conatins classes that are required
     * for the horses to work.
     */
    public AbstractHorse(){
        
    }
    
    /**
     * Moves the horse forward
     * 
     * @param finish The position of the finish line so the program will know
     * when to stop the race
     */
    public abstract void forward(int finish);
    
    /**
     * 
     * @return Returns the x-coordinate for the horse
     */
    public int getX(){
        return x;
    }
    
    /**
     * Sets the x-coordinate for the horse
     * 
     * @param x The value you wish to change the x-coordinate into
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * 
     * @return Returns the start number for the horse
     */
    public int getStartNbr(){
        return startNbr;
    }
}