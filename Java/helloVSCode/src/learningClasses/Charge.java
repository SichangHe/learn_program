package learningClasses;

public class Charge {

    // position of the charge
    private final double rx, ry;

    // charge of the charge
    private final double q;

    // constructor
    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    /**
     * return the electronic potential at point (x, y)
     */
    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }
}
