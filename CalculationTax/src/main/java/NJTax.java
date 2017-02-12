/**
 * Created by Alex on 30.10.2016.
 */
public class NJTax extends Tax {
    public double adjustForStudents(double tax){
        return tax - 500;
    }

    public double calcTax(){
        if (grossIncome < 50000){
            return grossIncome * 0.1;
        }
        else{
            return grossIncome * 0.13;
        }
    }
    NJTax (int nod, double gi, String st){
        numberOfDependents = nod;
        grossIncome = gi;
        state = st;
    }
}
