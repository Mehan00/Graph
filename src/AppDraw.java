import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class AppDraw extends JFrame {
    private ControlPanel controlPanel;
    GraphPanel graphPanel;
    Color currentColor;

    //poczatkowe wartosci dla funkcji, poza ekranem XD
    public int a=0;
    public int b=1000;
    public int c=1000;
    

    public AppDraw(String title) {
        
        super(title);
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(700,500);
        setLocation(100, 100);
        setResizable(false);

        ControlPanel controlPanel=new ControlPanel(this);
        GraphPanel graphPanel=new GraphPanel(this);
        add(controlPanel,BorderLayout.NORTH);
		add(graphPanel,BorderLayout.SOUTH);
		controlPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		pack();
        
    }

    
   
}
