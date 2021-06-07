import java.util.ArrayList;

public class LinearFunction extends Function{

	
	public LinearFunction(int x1, int wyWolny) {
		super(0, x1, wyWolny);
		setMiejscaZerowe( obliczMiejscaZerowe(x1, wyWolny) );
	}

	@Override
	public char getTyp() {
		return 'l';
	}
	
	@Override
	public String toString() {
		String tempWzorFunkcji = new String(
				"f(x) = "+String.format("%dx", this.getWsDoPierwszej())
				+String.format(" %+dx<br>", this.getWyrazWolny()));
		String tempMiejscaZerowe ="";
		for (int i=0; i<this.getMiejscaZerowe().size(); i++) {
				tempMiejscaZerowe += String.format("m%d = ", i)
					+String.format("%.4f<br>", this.getMiejscaZerowe().get(i));
		}
		return "<html>"+tempWzorFunkcji + tempMiejscaZerowe+"</html>";
	}
	public ArrayList<Double> obliczMiejscaZerowe(int a, int b) {
		ArrayList<Double> temp = new ArrayList<Double>();
		if (a == 0){
            return temp;
        }
        else{
            temp.add((double)-b/(double)a);
            return temp;
        }
	}
}
