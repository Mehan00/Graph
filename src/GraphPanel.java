import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;


//Główna klasa gdzie będzie rysowana nasza funkcja
//bazowa skala 50

class GraphPanel<DrawMainFrame> extends JPanel{
    private DrawMainFrame parentFrame;
    public GraphPanel(DrawMainFrame parentFrame) {
        this.parentFrame=parentFrame;
        setPreferredSize(new Dimension(600,600));
        
    }
    
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;
        int scale = 5;
        int w = this.getWidth()/2;
        int h = this.getHeight()/2;
        
        g1.setColor(Color.gray);
        //linie y
        for (int i = 0; i < 15; i++) {
            g1.drawLine(0+50*i,0,0+50*i,600);
        }
        //linie x
          for (int i = 0; i < 15; i++) {
            g1.drawLine(0,0+50*i,600,0+50*i);
        }

        //podanie skali pomocniczej
        for (int i = 1; i < 7; i++) {
            Integer temp = i*10;
            String stringtemp = temp.toString();
            g1.drawString(stringtemp, w - 15+50*i, h + 15);
        }
        for (int i = 1; i < 7; i++) {
            Integer temp = i*10;
            String stringtemp = temp.toString();
            g1.drawString(stringtemp, w - 18-50*i, h + 15);
        }
        for (int i = 1; i < 7; i++) {
            Integer temp = i*10;
            String stringtemp = temp.toString();
            g1.drawString(stringtemp,  w - 18, h + 15+50*i);
        }
        for (int i = 1; i < 7; i++) {
            Integer temp = i*10;
            String stringtemp = temp.toString();
            g1.drawString(stringtemp, w - 15, h + 15-50*i);
        }
        
        
        //główny układ współrzędnych
        g1.setColor(Color.black);
        g1.setStroke(new BasicStroke(3));
        g1.drawLine(0,h,w*2,h);
        g1.drawLine(w,0,w,h*2); 
        g1.drawString("0", w - 8, h + 15);

        //przykładowe funkcja 
        g1.setColor(Color.red);
        Polygon p1 = new Polygon();
        for (int x = -600; x <= 600; x++) {
            p1.addPoint(w+scale*x, h - scale*((4*x) + 3));
        }
        g1.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);

        g1.setColor(Color.green);
        Polygon p2 = new Polygon();
        for (int x = -600; x <= 600; x++) {
            p2.addPoint(w+scale*x, h - scale*((x*x) + 10));
        }
        g1.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);
        
        //---------------------------------------------
        
	}
}
