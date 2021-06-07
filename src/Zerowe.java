
public class Zerowe {

    //funkcja liniowa
    public String linezero(int a, int b){
        if (a == 0){
           
            return "Brak ";
        }
        else{
            double x0 = (double)-b/(double)a;
            return "m0 ="+Double.toString(x0);
        }  
    }
    // //funkcja kwadratowa i warunki 
    public String quadzero(int a, int b, int c){
        double delta = ( b * b ) - (4 * a * c);
        if(delta > 0){
            double x0 = ((double)-b - Math.sqrt(delta)) / (2 * (double)a);
            double x1 = ((double)-b + Math.sqrt(delta)) / (2 * (double)a);
            return "m0 =" + Double.toString(x0) + " m1 =" + Double.toString(x1);
        }
        if(delta == 0){
            double x0 = (double)-b/ 2 * (double)a; 
            return "m0 ="+ x0 ;  
        }
        if(delta<0){
            System.out.println("Brak miejsc zerowych");
            return "Brak miejsc zerowych";
        }
        return null;  
    }

}
