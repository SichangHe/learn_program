/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        double x_1 = Math.toRadians(Double.parseDouble(args[0]));
        double y_1 = Math.toRadians(Double.parseDouble(args[1]));
        double x_2 = Math.toRadians(Double.parseDouble(args[2]));
        double y_2 = Math.toRadians(Double.parseDouble(args[3]));
        double r = 6371.0;

        //Haversine formula
        double distance = 2 * r * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin((x_2 - x_1) / 2), 2)
                                + Math.cos(x_1) * Math.cos(x_2) * Math
                                .pow(Math.sin((y_2 - y_1) / 2), 2)
                )
        );
        System.out.println(distance+" kilometers");
    }
}
