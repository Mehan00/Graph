import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

//	#Klasa ktora obsluguje panel sterowania i komunikuje sie z GraphPanel
class ControlPanel extends JPanel{
	
	//	#pola ktore tworza historie malowan, czyli lista obiektow i 
	//	#indeks aktualnie wyswietlanej funkcji.
	private List<Function> history;
	private int historyIndex;
	
	//private JMenuBar mbMenuGlowne;
	//private JMenuItem jmiPoprzedni, jmiNastepny;
	
    private AppDraw parentFrame;
	private JButton drawButton , poprzedniaFunkcja, kolejnaFunkcja;
	private JRadioButton liniowa, kwadratowa;
    private ButtonGroup bg;
    private JTextField linA,linB,quadA,quadB,quadC;
    private JLabel labelA,labelB1,labelB2, funkcjaWynik, labelfx1, labelfx2;
	private int akcja = 1;
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	
	public ControlPanel(AppDraw parentFrame) {
		try {
		setPreferredSize(new Dimension(600,200));
		this.history = new ArrayList<Function>();
		this.historyIndex= -1;
		
//	INTERFEJS
		
		//	Button Group radio button (liniowa lub kwadratowa)
		liniowa = new JRadioButton("LINIOWA");
		kwadratowa = new JRadioButton("KWADRATOWA");
		bg=new ButtonGroup();
		bg.add(liniowa);
		bg.add(kwadratowa);
		p.add(liniowa);
		p1.add(kwadratowa);
		liniowa.setSelected(true);
		
		//	Pola Tekstowe
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
		funkcjaWynik = new JLabel("");
		labelfx1 = new JLabel("f(x)= ");
		labelfx2 = new JLabel("f(x)= ");
		
			//liniowa
		p.add(labelfx1);
		p.add(linA);
		p.add(labelA);
		p.add(linB);

			//kwadratowa
		p1.add(labelfx2);
		p1.add(quadA);
		p1.add(labelB1);
		p1.add(quadB);
		p1.add(labelB2);
		p1.add(quadC);
		

		//klasa anonimowa
		Zerowe zerowe = new Zerowe();
		
		//	Kontrolka rysuj
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
					try {
						if (akcja == 1)
						{
							parentFrame.a = Integer.parseInt(linA.getText());
							parentFrame.b = Integer.parseInt(linB.getText());
							parentFrame.flag = 'l';
							
							history.add(new LinearFunction(parentFrame.a, parentFrame.b));
							historyIndex++;
							funkcjaWynik.setText(getWzorFunkcji(zerowe.linezero(parentFrame.a,parentFrame.b), history.get(historyIndex)));
						}
						if (akcja == 2)
						{
							parentFrame.a = Integer.parseInt(quadA.getText());
							parentFrame.b = Integer.parseInt(quadB.getText());
							parentFrame.c = Integer.parseInt(quadC.getText());
							parentFrame.flag = 'k';
							
							history.add(new SquareFunction(parentFrame.a, parentFrame.b, parentFrame.c));
							historyIndex++;
							funkcjaWynik.setText(getWzorFunkcji(zerowe.quadzero(parentFrame.a,parentFrame.b,parentFrame.c), history.get(historyIndex)));
						}
						
						parentFrame.repaint();
						System.out.println(parentFrame.a);
						System.out.println(parentFrame.b);
						System.out.println(parentFrame.c);
					}
					catch (NumberFormatException err) {
						throw new IncorrectGraphDataInput("Niepoprawne dane w polach tekstowych.", parentFrame);
					}
					
				}
				catch (IncorrectGraphDataInput err){
					System.out.println(parentFrame.a);
					System.out.println(parentFrame.b);
					System.out.println(parentFrame.c);
				}
				catch (Exception err) {
					err.printStackTrace();
					System.out.println("Niespodziewany b��d");
					System.out.println(parentFrame.a);
					System.out.println(parentFrame.b);
					System.out.println(parentFrame.c);
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
						parentFrame.flag = 'l';
						parentFrame.a = temp.getWsDoPierwszej();
						parentFrame.b = temp.getWyrazWolny();
						
						funkcjaWynik.setText(getWzorFunkcji(zerowe.linezero(parentFrame.a,parentFrame.b), history.get(historyIndex)));
					}else {
						parentFrame.flag = 'k';
						parentFrame.a = temp.getWsDoGrugiej();
						parentFrame.b = temp.getWsDoPierwszej();
						parentFrame.c = temp.getWyrazWolny();
						
						funkcjaWynik.setText(getWzorFunkcji(zerowe.quadzero(parentFrame.a,parentFrame.b,parentFrame.c), history.get(historyIndex)));
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
						parentFrame.flag = 'l';
						parentFrame.a = temp.getWsDoPierwszej();
						parentFrame.b = temp.getWyrazWolny();
						
						funkcjaWynik.setText(getWzorFunkcji(zerowe.linezero(parentFrame.a,parentFrame.b), history.get(historyIndex)));
					}else {
						parentFrame.flag = 'k';
						parentFrame.a = temp.getWsDoGrugiej();
						parentFrame.b = temp.getWsDoPierwszej();
						parentFrame.c = temp.getWyrazWolny();
						
						funkcjaWynik.setText(getWzorFunkcji(zerowe.quadzero(parentFrame.a,parentFrame.b,parentFrame.c), history.get(historyIndex)));
					}
					
					parentFrame.repaint();
					
				}
				
				
			}
		});
		
	//koniec konstruktora
		}
        catch(Exception err){
        	new GraphUnknownException("Exception caught in class ControlPanel. In the constructor.\n"
        			+ "The actual values of the parentFrame are a= "+parentFrame.a + ", b= "+parentFrame.b+", c= "+parentFrame.c + ", flag= " +parentFrame.flag + "\n", err);
        }
	}
	
//	#metoda klasy ktora generuje String ktory jest reprezentacja wzoru funkcji i jej miejsca zerowego.
	private String getWzorFunkcji(String miejsceZerowe, Function function) {
		if (function.getTyp()=='l') {
			return "<html>f(x) = " + function.getWsDoPierwszej()+"x +"+ function.getWyrazWolny()+ "<br>"+ miejsceZerowe + "</html>";
		}
		else if (function.getTyp()=='k') {
			return "<html>f(x) = " + function.getWsDoGrugiej()+"x^2 +"+function.getWsDoPierwszej()+"x +"+ function.getWyrazWolny()+ "<br>"+ miejsceZerowe + "</html>";
		}
		return null;
	}
	
//	#wewnetrzna klasa wyjatku ktora kontroluje poprawnosc dannych w polach tekstowych, przed rysowaniem funkcji.
	public class IncorrectGraphDataInput extends Exception {
		
		public IncorrectGraphDataInput(String messageTitle, AppDraw frame) {
			JOptionPane.showMessageDialog(frame, messageTitle);
		}
	}
	
}
