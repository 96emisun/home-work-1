public class NormalHorse extends AbstractHorse {

    protected int x, y, startNbr;
    protected MainGUI gui;
    
    public NormalHorse(int x, int y, int startNbr) {
        super(x, y, startNbr);
        this.x = x;
        this.y = y;
        this.startNbr = startNbr;
        this.gui = new MainGUI();
        
    }

    @Override
    public void forward() {
        int i = 0;
        gui.moveTo(0, 200);

        while(i <= 600){

            gui.lineTo(i, 200);
            i++;
            gui.delay(5);
        }
    }


}
