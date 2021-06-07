import java.util.ArrayList;

public class SquareFunction extends Function{
	
	public SquareFunction(int x2, int x1, int wyWolny) {
		super(x2,x1,wyWolny);
		setMiejscaZerowe( obliczMiejscaZerowe(x2, x1, wyWolny) );
	}

	@Override
	public char getTyp() {
		return 'k';
	}

	@Override
	public String toString() {
		String tempWzorFunkcji = new String(
				"f(x) = "+String.format("%dx\u00B2", this.getWsDoDrugiej())
				+String.format("%+dx", this.getWsDoPierwszej())
				+String.format(" %+dx<br>", this.getWyrazWolny()));
		String tempMiejscaZerowe ="";
		ArrayList<Double> listMiejscaZerowe = this.getMiejscaZerowe();
		if (listMiejscaZerowe.size() == 0) {
			tempMiejscaZerowe = "brak miejsc zerowych";
		}else {
			for (int i=0; i<this.getMiejscaZerowe().size(); i++) {
				tempMiejscaZerowe += String.format("m%d = ", i)
					+String.format("%.4f<br>", this.getMiejscaZerowe().get(i));
			}
		}
		return "<html>"+tempWzorFunkcji + tempMiejscaZerowe+"</html>";
	}
	public ArrayList<Double> obliczMiejscaZerowe(int a, int b, int c) {
		ArrayList<Double> temp = new ArrayList<Double>();
		double delta = ( b * b ) - (4 * a * c);
        if(delta > 0){
            temp.add(((double)-b - Math.sqrt(delta)) / (2 * (double)a));
            temp.add(((double)-b + Math.sqrt(delta)) / (2 * (double)a));
            return temp;
        }
        if(delta == 0){
            temp.add((double)-b/ 2 * (double)a);  
        }
        return temp;
	}
}
