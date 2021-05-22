import java.awt.Dimension;
import javax.swing.JPanel;

//klasa do panelu sterowania
//tutaj będą podawane współrzędne na podstawie, których w klasie GraphPanel będą rysowane
class ControlPanel extends JPanel{
    private AppDraw parentFrame;
	
		public ControlPanel(AppDraw parentFrame) {
			this.parentFrame=parentFrame;
			setPreferredSize(new Dimension(600,200));
		
		}
}
