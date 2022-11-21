import java.util.Scanner;

public class input {
    public static void main(String[] args) {

        //define a scanner
        Scanner sc= new Scanner(System.in);

        //get a as double
        Double a= sc.nextDouble();

        //get b as a string
        String b = sc.nextLine();

        //print a, b
        System.out.println(a + b);
    }
}