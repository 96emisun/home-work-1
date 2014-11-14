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
        MainGUI.gui.moveTo(x, y);
        x++;
        MainGUI.gui.lineTo(x, y);
    }


}
