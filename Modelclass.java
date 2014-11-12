
import java.util.ArrayList;

public class Modelclass{

    private ArrayList<AbstractHorse> array;
    
    public Modelclass(){
        array = new ArrayList<AbstractHorse>();
    }
    
    public void startRace(){
        
        int max = 0;
        
        while(max < 500){
            for(AbstractHorse horse : array){
                horse.forward();
                if(max < horse.getX()){
                    max = (int)horse.getX();
                }
            }
        }
    }
    
    public void addHorse(AbstractHorse horse){
        array.add(horse);
    }
}
