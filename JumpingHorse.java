
public class JumpingHorse extends AbstractHorse implements Comparable {

    protected int x, y, startNbr;
    
    public JumpingHorse(int x, int y, int startNbr) {
        super(x, y, startNbr);
        this.x = x;
        this.y = y;
        this.startNbr = startNbr;
    }
    
    @Override
    public void forward(){
        
    }

    @Override
    public int compareTo(Comparable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
