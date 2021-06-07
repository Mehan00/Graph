import java.util.ArrayList;

public abstract class Function {
	
	private int wsDoDrugiej, wsDoPierwszej, wyrazWolny;
	private ArrayList<Double> miejscaZerowe;
	
	public Function (int a, int b, int c) {
		this.wsDoDrugiej = a;
		this.wsDoPierwszej = b;
		this.wyrazWolny = c;
	} 
	
	protected void setMiejscaZerowe(ArrayList<Double> miejscaZerowe) {
		this.miejscaZerowe = miejscaZerowe;
	}
	
	public ArrayList<Double> getMiejscaZerowe() {
		return this.miejscaZerowe;
	}
	public int getWsDoDrugiej() {
		return wsDoDrugiej;
	}

	public int getWsDoPierwszej() {
		return wsDoPierwszej;
	}

	public int getWyrazWolny() {
		return wyrazWolny;
	}
	
	@Override
	public abstract String toString();
	
	public abstract char getTyp();
	
}
