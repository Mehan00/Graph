import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;


//Główna klasa gdzie będzie rysowana nasza funkcja

class GraphPanel<DrawMainFrame> extends JPanel{
    private DrawMainFrame parentFrame;
    public GraphPanel(DrawMainFrame parentFrame) {
        this.parentFrame=parentFrame;
        setPreferredSize(new Dimension(800,600));
        
    }
    
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;

        int w = this.getWidth()/2;
        int h = this.getHeight()/2;

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(2));
        g1.setColor(Color.black);
        g1.drawLine(0,h,w*2,h);
        g1.drawLine(w,0,w,h*2); 
        g1.drawString("0", w - 7, h + 13);
	}
}