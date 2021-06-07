import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

//	#Klasa ktora obsluguje panel sterowania i komunikuje sie z GraphPanel
class ControlPanel extends JPanel{
	
	//	#pola ktore tworza historie malowan, czyli lista obiektow i 
	//	#indeks aktualnie wyswietlanej funkcji.
	private List<Function> history;
	private int historyIndex;
	
    private AppDraw parentFrame;
	private JButton drawButton , poprzedniaFunkcja, kolejnaFunkcja;
	private JRadioButton liniowa, kwadratowa;
    private ButtonGroup bg;
    private JTextField linA,linB,quadA,quadB,quadC;
    private JLabel labelA,labelB1,labelB2, funkcjaWynik, labelfx1, labelfx2;
	private int akcja = 1;
	
	//	#do lepszego ulozenia kontrolek w programie
	private JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	
	public ControlPanel(AppDraw parentFrame) {
		try {
		setPreferredSize(new Dimension(600,220));
		this.history = new ArrayList<Function>();
		this.historyIndex= -1;
		
//	INTERFEJS
		
		liniowa = new JRadioButton("LINIOWA");
		kwadratowa = new JRadioButton("KWADRATOWA");
		bg=new ButtonGroup();
		bg.add(liniowa);
		bg.add(kwadratowa);
		p.add(liniowa);
		p1.add(kwadratowa);
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
		labelB1 = new JLabel("x\u00B2 + ");
		labelB2 = new JLabel("x + ");
		funkcjaWynik = new JLabel("");
		labelfx1 = new JLabel("f(x) = ");
		labelfx2 = new JLabel("f(x) = ");
		
			//liniowa label i textfield
		p.add(labelfx1);
		p.add(linA);
		p.add(labelA);
		p.add(linB);
		
			//kwadratowa label i textfield
		p1.add(labelfx2);
		p1.add(quadA);
		p1.add(labelB1);
		p1.add(quadB);
		p1.add(labelB2);
		p1.add(quadC);
		
		drawButton = new JButton("Rysuj");
		p2.add(drawButton);
		
		//	Kontrolki do obslugi histori malowan funkcji
		poprzedniaFunkcja = new JButton("<");
		kolejnaFunkcja = new JButton(">");
		p3.add(poprzedniaFunkcja);
		p3.add(kolejnaFunkcja);
		
		p4.add(funkcjaWynik);
		
		add(p, BorderLayout.WEST);
		add(p1,BorderLayout.WEST);
		add(p2,BorderLayout.NORTH);
		add(p3,BorderLayout.NORTH);
		add(p4,BorderLayout.SOUTH);

		p.setPreferredSize(new Dimension(580, 30));
		p1.setPreferredSize(new Dimension(580, 30));
		p2.setPreferredSize(new Dimension(580, 30));
		p3.setPreferredSize(new Dimension(580, 30));
		
//ACTION LISTENERS
		
		liniowa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				linA.setEditable(true);
				linB.setEditable(true);
				quadA.setText("");
				quadB.setText("");
				quadC.setText("");
				quadA.setEditable(false);
				quadB.setEditable(false);
				quadC.setEditable(false);
				akcja = 1;
				funkcjaWynik.setText("");
			}
		});

		kwadratowa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quadA.setEditable(true);
				quadB.setEditable(true);
				quadC.setEditable(true);
				linA.setText("");
				linB.setText("");
				linA.setEditable(false);
				linB.setEditable(false);
				akcja = 2;
				funkcjaWynik.setText("");
			}
		});

		//Akcja dla przycisku rysowania
		drawButton.addActionListener (new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						if (akcja == 1)
						{
							parentFrame.setA(Integer.parseInt(linA.getText()));
							parentFrame.setB(Integer.parseInt(linB.getText()));
							parentFrame.setFlag('l');
							
							history.add(new LinearFunction(parentFrame.getA(), parentFrame.getB()));
							historyIndex = history.size()-1;
							funkcjaWynik.setText(history.get(historyIndex).toString());
						}
						if (akcja == 2)
						{
							parentFrame.setA(Integer.parseInt(quadA.getText()));
							parentFrame.setB(Integer.parseInt(quadB.getText()));
							parentFrame.setC(Integer.parseInt(quadC.getText()));
							parentFrame.setFlag('k');
							
							history.add(new SquareFunction(parentFrame.getA(), parentFrame.getB(), parentFrame.getC()));
							historyIndex++;
							funkcjaWynik.setText(history.get(historyIndex).toString());
						}
						
						parentFrame.repaint();
					}
					catch (Exception err) {
						JOptionPane.showMessageDialog(parentFrame, "Niepoprawne dane w polach tekstowych.");
					}
				
			}

		});
		
		poprzedniaFunkcja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (history.size() >= 2 && historyIndex > 0)
				{
					historyIndex--;
					System.out.println(historyIndex);
					Function temp = history.get(historyIndex);
					
					if (temp.getTyp() == 'l') {
						parentFrame.setFlag('l');
						parentFrame.setA(temp.getWsDoPierwszej());
						parentFrame.setB(temp.getWyrazWolny());
						funkcjaWynik.setText(history.get(historyIndex).toString());
					}else {
						parentFrame.setFlag('k');
						parentFrame.setA(temp.getWsDoDrugiej());
						parentFrame.setB(temp.getWsDoPierwszej());
						parentFrame.setC(temp.getWyrazWolny());
						funkcjaWynik.setText(history.get(historyIndex).toString());
					}
					
					parentFrame.repaint();
					
				}
				
				
			}
		});
		
		kolejnaFunkcja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (historyIndex < history.size() -1)
				{
					historyIndex++;
					System.out.println(historyIndex);
					Function temp = history.get(historyIndex);
					
					if (temp.getTyp() == 'l') {
						parentFrame.setFlag('l');
						parentFrame.setA(temp.getWsDoPierwszej());
						parentFrame.setB(temp.getWyrazWolny());
						funkcjaWynik.setText(history.get(historyIndex).toString());
					}else {
						parentFrame.setFlag('k');
						parentFrame.setA(temp.getWsDoDrugiej());
						parentFrame.setB(temp.getWsDoPierwszej());
						parentFrame.setC(temp.getWyrazWolny());
						funkcjaWynik.setText(history.get(historyIndex).toString());
					}
					
					parentFrame.repaint();
					
				}
				
				
			}
		});
		
	
		}
        catch(Exception err){
        	new GraphUnknownException("Exception caught in class ControlPanel. In the constructor.\n"
        			+ "The actual values of the parentFrame are a= "+parentFrame.getA() + ", b= "+parentFrame.getB()+", c= "+parentFrame.getC() + ", flag= " +parentFrame.getFlag() + "\n", err);
        }
	//koniec konstruktora
	}
	
}
