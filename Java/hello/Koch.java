public class Koch {
    // draw a koth curve
    public static void koth(int n, double step, Turtle turtle0) {
        if (n == 0) {
            turtle0.goForward(step);
            return;
        }
        koth(n - 1, step, turtle0);
        turtle0.turnLeft(60);
        koth(n - 1, step, turtle0);
        turtle0.turnLeft(-120);
        koth(n - 1, step, turtle0);
        turtle0.turnLeft(60);
        koth(n - 1, step, turtle0);
    }
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(0, 800);
        for (int i = 0; i <= 7; i++) {
            Turtle turtle = new Turtle((1 + i) * 50, 100, 90);
            koth(i, 100.0 / Math.pow(3, i), turtle);
        }
    }
}
