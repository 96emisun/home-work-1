
import java.util.ArrayList;

public class Modelclass{

    private ArrayList<AbstractHorse> horses;
    private AbstractHorse nHorse;
    
    public Modelclass(){
        horses = new ArrayList<AbstractHorse>();
    }
    
    public void startRace(){
        int size = horses.size();
        int max = 0;
        System.out.print(horses.isEmpty());
        while(max < 500){
            for(int i=0; i < size; i++){
                AbstractHorse horse = new NormalHorse(200, 200, 1);
                horse.forward();
                if(max < horse.getX()){
                    max = (int)horse.getX();
                }
            }
        }
    }
    
    public void addNormalHorse(){
        horses.add(nHorse);
        System.out.println("Lyckades");
    }
    
    public void drawStart(int x1, int y1, int x2, int y2){
        MainGUI.gui.moveTo(x1, y1);
        MainGUI.gui.lineTo(x2, y2);
    }
}
