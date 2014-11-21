package HorseRace;

/**
 * @author Emil Sundqvist
 */
public class RaceResults {
    private int nbrOfWins1;
    private int nbrOfWins2;
    
    public RaceResults(){
        this.nbrOfWins1 = 0;
        this.nbrOfWins2 = 0;
    }
    
    /*
    Compares the positions of the horses. Then returns a string containing
    information about the winner
    */
    public String checkWinner(AbstractHorse nHorse, AbstractHorse jHorse){
        
        int compared = nHorse.compareTo(jHorse);
        
        if(compared == 1){
            
            MainGUI.gui.drawString("WINNER", 510, 155);
            nbrOfWins1++;
            return "Horse #" + nHorse.getStartNbr() + " won!\n"
                    + "This horse has now won " + nbrOfWins1 + " time(s).";
        }
        else if(compared == -1){
            
            MainGUI.gui.drawString("WINNER", 510, 255);
            nbrOfWins2++;
            return "Horse #" + jHorse.getStartNbr() + " won!\n"
                    + "This horse has now won " + nbrOfWins2 + " time(s).";
        }
        else{
            return "It's a tie!";
        }
        
        
    }
    
}
