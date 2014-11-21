package HorseRace;

/**
 * @author Emil Sundqvist
 */
public class Race{

    private AbstractHorse nHorse;
    private AbstractHorse jHorse;
    private final RaceResults res;
    
    private int finish;
    private int start;
    
    private final int horseX;
    private final int horseOneY;
    private final int horseTwoY;
    
    /*
    The class Race contains methods that takes care of the race
    */
    public Race(){
        
        this.res = new RaceResults();
        
        this.horseX = 100;
        this.horseOneY = 150;
        this.horseTwoY = 250;
        
    }
    
    /*
    Moves the horses forward as long as none of them has crosses the finish line
    */
    public void startRace(){
        
        while(nHorse.getX() < finish && jHorse.getX() < finish){
            nHorse.forward(finish);
            jHorse.forward(finish);
            MainGUI.gui.delay(10);
        }

    }
    
    /*
    Adds the horses to predetermined coordniates
    */
    public void addHorses (){
        nHorse = new NormalHorse(start, horseOneY, 1);
        jHorse = new JumpingHorse(start, horseTwoY, 2);
        MainGUI.gui.drawCirc(start - 7, horseOneY - 7, 14);
        MainGUI.gui.drawCirc(start - 7, horseTwoY - 7, 14);
    }
    
    /*
    Resets the positions of the horses and draws everyting again
    */
    public void reset(){
        MainGUI.gui.clear();
        drawStartLine(start, 50, 350);
        drawFinishLine(finish, 50, 350);
        nHorse.setX(start);
        jHorse.setX(start);
    }
    
    /*
    Draws a line at the specified coordinates
    */
    public void drawStartLine(int x, int y1, int y2){
        this.start = x;
        MainGUI.gui.moveTo(x, y1);
        MainGUI.gui.lineTo(x, y2);
    }
    
    /*
    Draws a line at the specified coordinates
    */
    public void drawFinishLine(int x, int y1, int y2){
        this.finish = x;
        MainGUI.gui.moveTo(x, y1);
        MainGUI.gui.lineTo(x, y2);
        
    }
    
    /*
    Fetches the results from the RaceResults class
    */
    public String getResults(){
        return res.checkWinner(nHorse, jHorse);
    }
}
