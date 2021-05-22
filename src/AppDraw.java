import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;


public class AppDraw extends JFrame {

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