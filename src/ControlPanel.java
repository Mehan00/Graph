import java.awt.Dimension;
import javax.swing.JPanel;

//klasa do panelu sterowania
//tutaj będą podawane współrzędne na podstawie, których w klasie GraphPanel będą rysowane
class ControlPanel<DrawMainFrame> extends JPanel{
    private DrawMainFrame parentFrame;
	
		public ControlPanel(DrawMainFrame parentFrame) {
			this.parentFrame=parentFrame;
			setPreferredSize(new Dimension(700,200));
		
		}
}