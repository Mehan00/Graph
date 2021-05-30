import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class AppDraw extends JFrame {
    private ControlPanel controlPanel;
    private GraphPanel graphPanel;
    Color currentColor;

    public int a=0;
    public int b=1000;
    public int c=1000;
    public char flag = '-';													//flaga rysowania '-' nic, 'l' liniowa, 'k' kwadratowa

    public AppDraw(String title) {
        
    	super(title);
    	
        try {
        	Toolkit tk=Toolkit.getDefaultToolkit();
            Dimension dim = tk.getScreenSize();
            setSize(700,500);
            setLocation(100, 100);
            setResizable(false);
            
            //Panel zajmuj¹cy siê kontrolkami
            ControlPanel controlPanel=new ControlPanel(this);
            //Panel zajmuj¹cy siê rysowaniem funkcji
            GraphPanel graphPanel=new GraphPanel(this);
            
            add(controlPanel,BorderLayout.NORTH);
    		add(graphPanel,BorderLayout.SOUTH);
    		controlPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    		pack();
        }
        catch(Exception err){
        	new GraphUnknownException("Exception caught in class AppDraw. In the constructor.\n", err);
        }
    }
    

   
}
