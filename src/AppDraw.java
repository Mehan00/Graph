import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Color;


public class AppDraw extends JFrame {
    private ControlPanel controlPanel;
    private GraphPanel graphPanel;

    private int a=0;
    private int b=0;
    private int c=0;
    private char flag = '-';													//flaga rysowania '-' nic, 'l' liniowa, 'k' kwadratowa

	public AppDraw(String title) {
        
    	super(title);
    	
        try {
        	Toolkit tk=Toolkit.getDefaultToolkit();
            Dimension dim = tk.getScreenSize();
            setSize(700,520);
            setLocation(100, 100);
            setResizable(false);
            
            controlPanel=new ControlPanel(this);
            graphPanel=new GraphPanel(this);
            
            add(controlPanel,BorderLayout.NORTH);
    		add(graphPanel,BorderLayout.SOUTH);
    		controlPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    		pack();
        }
        catch(Exception err){
        	new GraphUnknownException("Exception caught in class AppDraw. In the constructor.\n", err);
        }
    }

	protected int getA() {
		return a;
	}

	protected void setA(int a) {
		this.a = a;
	}

	protected int getB() {
		return b;
	}

	protected void setB(int b) {
		this.b = b;
	}

	protected int getC() {
		return c;
	}

	protected void setC(int c) {
		this.c = c;
	}

	protected char getFlag() {
		return flag;
	}

	protected void setFlag(char flag) {
		this.flag = flag;
	}

	
	
	 
}
