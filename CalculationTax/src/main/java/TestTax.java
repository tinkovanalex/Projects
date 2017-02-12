/**
 * Created by Alex on 30.10.2016.
 */
public class TestTax {
    public static void main (String [] args){
        //Tax tax = new Tax();

        NJTax tax = new NJTax(2, 40000, "NY");
        //tax.grossIncome = 40000;
        //tax.numberOfDependents = 2;
        //tax.state = "NY";

        double yourTax = tax.calcTax();

        double njTax = tax.adjustForStudents(yourTax);

        System.out.println("Your tax is " + njTax);

    }
}
