/*package StdDrawImplementations;

public class BouncyBall {
    public static void main(String[] args) {
        // take the initial angle alpha, speed v, radius r, size d
        double alpha = Math.toRadians(Double.parseDouble(args[0])), v = Double.parseDouble(args[1]),
                r = Double.parseDouble(args[2]);
        int d = Integer.parseInt(args[3]);

        // set initial position x, y
        double x = d / 2.0, y = d / 2.0;

        // set up StdDraw
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(d + 2, d + 2);
        StdDraw.setXscale(-10, d+10);
        StdDraw.setYscale(-10, d+10);

        while (true) {
            // draw
            StdDraw.clear();
            StdDraw.circle(x, y, r);
            StdDraw.pause(20);
            StdDraw.show();

            // change direction
            if (x + v * Math.cos(alpha) > d || x + v * Math.cos(alpha) < 0) {
                alpha = Math.PI - alpha;
            }
            else if (y + v * Math.sin(alpha) > d || y + v * Math.sin(alpha) < 0) {
                alpha = -alpha;
            }

            // move
            x += v * Math.cos(alpha);
            y += v * Math.sin(alpha);

        }
    }
}
*/