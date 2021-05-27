
public abstract class Function {
	
	private int wsDoGrugiej, wsDoPierwszej, wyrazWolny;
	
	public Function (int a, int b, int c) {
		this.wsDoGrugiej = a;
		this.wsDoPierwszej = b;
		this.wyrazWolny = c;
	}

	public int getWsDoGrugiej() {
		return wsDoGrugiej;
	}

	public int getWsDoPierwszej() {
		return wsDoPierwszej;
	}

	public int getWyrazWolny() {
		return wyrazWolny;
	}
	
	public abstract char getTyp();
	
}
