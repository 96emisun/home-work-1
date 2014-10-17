
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainGUI extends JFrame {
    
    /*
        GUI-komponenter
    */
    
    private Dimension dimFrame, dimButton, dimTXF;
    
    private JMenuBar menu;
    private JMenu archive;
    private JMenuItem terminate;
    
    private JTabbedPane jtp;
    private JPanel pteacher, pstudent, pclass;
    private JTextField txfTeacher, txfStudent;
    private JTextArea txaClass;
    private JButton btnAddTeacher, btnAddStudent, btnPrintClass;
    private JLabel lblTeacher, lblStudent, lblPrint;
    
    /*
        Modell variabler
    */
    
    private Modelclass Model;
    
    public MainGUI (){
        this.initGUI();
        this.Model = new Modelclass();
    }
    
    
    
    
    
    /*
        Inställningar för JFramen
    */
    private void initGUI(){
        /*
            Standard storlekar för GUI-komponenterna
        */
        
        this.dimFrame = new Dimension(300, 400);
        this.dimTXF = new Dimension(125, 50);
        this.dimButton = new Dimension(125, 30);
        
        this.setTitle("Klasslista");
        this.setSize( dimFrame );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*
            Skapar menyerna
        */
        
        this.menu = new JMenuBar();
        this.archive = new JMenu("Arkiv");
        this.terminate = new JMenuItem("Avsluta programmet");
        
        this.setJMenuBar(menu);
        this.menu.add(archive);
        this.archive.add(terminate);
        
        this.terminate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        /*
            Flikarna skapas
        */
        this.jtp = new JTabbedPane();
        this.add(jtp);
        
        this.pclass = new JPanel();
        this.pstudent = new JPanel();
        this.pteacher = new JPanel();
        
        this.jtp.addTab("Student", pstudent);
        this.jtp.addTab("Teacher", pteacher);
        this.jtp.addTab("Class", pclass);
        
        /*
            Teacher-fliken FlowLayout manager
        */
        this.lblTeacher = new JLabel("Teacher to add");
        this.txfTeacher = new JTextField();
        this.txfTeacher.setPreferredSize(dimTXF);
        
        this.pteacher.add(this.lblTeacher);
        this.pteacher.add(this.txfTeacher);
        this.pteacher.add(this.btnAddTeacher);
        
        /*
            Student-fliken FlowLayout manager
        */
        this.lblStudent = new JLabel("Student to add");
        this.txfStudent = new JTextField();
        this.txfStudent.setPreferredSize(dimTXF);
        
        this.pstudent.add(this.lblStudent);
        this.pstudent.add(this.txfStudent);
        this.pstudent.add(this.btnAddStudent);
        
        /*
            Klass-fliken BorderLayout
        */
        this.pclass.setLayout(new BorderLayout(10, 10));
        this.lblPrint = new JLabel("Print Class");
        this.txaClass = new JTextArea(10, 25);
        this.txaClass.setEditable(false);
        
        this.pclass.add(this.lblPrint, BorderLayout.NORTH);
        this.pclass.add(this.txaClass, BorderLayout.CENTER);
        this.pclass.add(this.btnPrintClass, BorderLayout.SOUTH);
        
    }
    
    
    
    
    //Följande rader säkrar att GUI:et startar i EDT.
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    
}
