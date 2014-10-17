
import java.awt.Point;

public abstract class AbstractHorse{
    static int nbrOfHorses;
    private int startNbr;
    private Point p;
    private int speed;
    private int nbrOfSteps;
    private int direction; //lagrar riktning som 1, 2, 3, 4.
    
    public AbstractHorse(int x, int y, int startNbr){
        this.nbrOfSteps = 0;
        this.speed = 0;
        this.direction = 0;
        this.startNbr = 0;
    }
    
    public abstract void turnLeft();
    public abstract void turnRight();
    public abstract void turnNorth();
    public abstract void speedUp();
    public abstract void speedDown();
    
    public double getX(){
        
    }
    
    public double getY(){
        
    }
    
    public int getstartNbr(){
        return startNbr;
    }
    public int getNbrOfSteps(){
        return nbrOfSteps;
    }
}




