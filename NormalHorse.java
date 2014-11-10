public class NormalHorse extends AbstractHorse {

    protected int x, y, startNbr;
    
    public NormalHorse(int x, int y, int startNbr) {
        super(x, y, startNbr);
        this.x = x;
        this.y = y;
        this.startNbr = startNbr;
    }

    @Override
    public void forward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
