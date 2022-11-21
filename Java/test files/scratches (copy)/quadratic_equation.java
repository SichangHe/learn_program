import java.util.*;
public class quadratic_equation {
    public static void main(String[] args) {

        //define a scanner
        Scanner sc= new Scanner(System.in);

        //tell the user to input a
        System.out.print("plz input \"a\" in \"ax^2 + bx + c = 0\"");
        //get a as double
        Double a= sc.nextDouble();

        //tell the user to input b
        System.out.print("plz input \"b\" in \"ax^2 + bx + c = 0\"");
        //get b as double
        Double b= sc.nextDouble();

        //tell the user to input c
        System.out.print("plz input \"c\" in \"ax^2 + bx + c = 0\"");
        //get c as double
        Double c= sc.nextDouble();

        //calculate delta
        double Delta = Math.pow(b, 2) - 4 * a * c;
        System.out.println("Delta = "+ Delta);

        //calculate x
        double x1 = -b - Math.sqrt(Delta) / 2 / a;
        double x2 = -b + Math.sqrt(Delta) / 2 / a;
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }
}