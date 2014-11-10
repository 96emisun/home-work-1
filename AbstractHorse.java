
public abstract class AbstractHorse{
    static int nbrOfHorses;
    private int x;
    private int y;
    private int startNbr;
    private int speed;
    private int nbrOfSteps;
    private int direction; //lagrar riktning som 1, 2, 3, 4.
    
    public AbstractHorse(int x, int y, int startNbr){
        this.nbrOfSteps = 0;
        this.speed = 0;
        this.direction = 0;
        this.startNbr = 0;
        this.x = 0;
        this.y = 0;
    }
    
    public abstract void forward();
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public int getstartNbr(){
        return startNbr;
    }
    public int getNbrOfSteps(){
        return nbrOfSteps;
    }
}




