import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;


//klasa do panelu sterowania
//tutaj bÄ™dÄ… podawane wspÃ³Å‚rzÄ™dne na podstawie, ktÃ³rych w klasie GraphPanel bÄ™dÄ… rysowane
class ControlPanel extends JPanel{
	
    private AppDraw parentFrame;
	private JButton drawButton;
	private JRadioButton liniowa,kwadratowa;
    private ButtonGroup bg;
    private JTextField linA,linB,quadA,quadB,quadC;
    private JLabel labelA,labelB1,labelB2,mzero;
	private int akcja = 1;

	
	
	public ControlPanel(AppDraw parentFrame) {
		this.parentFrame=parentFrame;
		setPreferredSize(new Dimension(600,200));


		//interfejs
		liniowa = new JRadioButton("LINIOWA");
		kwadratowa = new JRadioButton("KWADRATOWA");
		bg=new ButtonGroup();
		bg.add(liniowa);
		bg.add(kwadratowa);
		add(liniowa);
		add(kwadratowa);
		liniowa.setSelected(true);
		

		linA = new JTextField(3);
		linB = new JTextField(3);
		quadA = new JTextField(3);
		quadB = new JTextField(3);
		quadC = new JTextField(3);

		quadA.setEditable(false);
		quadB.setEditable(false);
		quadC.setEditable(false);

		labelA = new JLabel("x + ");
		labelB1 = new JLabel("x^2 + ");
		labelB2 = new JLabel("x + ");
		mzero = new JLabel("m0= ");
		
		//akcja dla funkcji liniowej
		liniowa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				quadA.setText("");
				quadB.setText("");
				quadC.setText("");
				linA.setEditable(true);
				linB.setEditable(true);
				quadA.setEditable(false);
				quadB.setEditable(false);
				quadC.setEditable(false);
				akcja = 1;
				///System.out.println(akcja);
			}
		});

		//akcja dla funkcji kwadratowej
		kwadratowa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				linA.setText("");
				linB.setText("");
				linA.setEditable(false);
				linB.setEditable(false);
				quadA.setEditable(true);
				quadB.setEditable(true);
				quadC.setEditable(true);
				akcja = 2;
				//System.out.println(akcja);
			}
		});

		//liniowa
		add(linA);
		add(labelA);
		add(linB);

		//kwadratowa
		add(quadA);
		add(labelB1);
		add(quadB);
		add(labelB2);
		add(quadC);
		add(mzero);

		//klasa anonimowa
		Zerowe zerowe = new Zerowe();
		
		//funkcja glownego przycisku do rysowania
		drawButton=new JButton("Rysuj");
		add(drawButton);
		drawButton.addActionListener(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						if (akcja == 1)
						{
							parentFrame.a = Integer.parseInt(linA.getText());
							parentFrame.b = Integer.parseInt(linB.getText());
							parentFrame.flag = 'l';
							mzero.setText(zerowe.linezero(parentFrame.a,parentFrame.b));
							
							
						}
						if (akcja == 2)
						{
							parentFrame.a = Integer.parseInt(quadA.getText());
							parentFrame.b = Integer.parseInt(quadB.getText());
							parentFrame.c = Integer.parseInt(quadC.getText());
							parentFrame.flag = 'k';
							mzero.setText(zerowe.quadzero(parentFrame.a,parentFrame.b,parentFrame.c));
						}
						
						parentFrame.repaint();
						
					}
					catch (NumberFormatException err) {
						throw new IncorrectGraphDataInput("Niepoprawne dane w polach tekstowych.", parentFrame);
					}
					
				}
				catch (IncorrectGraphDataInput err){
					
				}
				catch (Exception err) {
					err.printStackTrace();
					System.out.println("Niespodziewany b³¹d");
					
				}
				
			}
		});

		

	}
	

	public class IncorrectGraphDataInput extends Exception {
		
		public IncorrectGraphDataInput(String messageTitle, AppDraw frame) {
			JOptionPane.showMessageDialog(frame, messageTitle);
		}
	}
}
