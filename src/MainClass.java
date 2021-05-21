
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//okno glowne programu

public class MainClass {
    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){
            public void run(){
                GraphDraw graph =new GraphDraw("Rysowanie Funkcji");
                graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
                graph.setVisible(true);
                 
            }
        });
    }
    
    
}

