public class Turtle {
    // instance variable inside the reference type
    private double x, y;
    private double angle;

    // constructor, with the same name as the class
    public Turtle(double x0, double y0, double angle0) {
        x = x0;
        y = y0;
        angle = angle0;
    }

    /**
     * rotate the direction of the turtle to the left by delta degrees
     */
    public void turnLeft(double delta) {
        angle += delta;
    }

    /*
     * let the turtle go forward step a
     */
    public void goForward(double a) {
        StdDraw.line(x, y, x + a * Math.cos(Math.toRadians(angle)), y + a * Math.sin(Math.toRadians(angle)));
        x += a * Math.cos(Math.toRadians(angle));
        y += a * Math.sin(Math.toRadians(angle));
    }

    public static void main(String[] args) {

    }
}
