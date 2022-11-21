public class Checkerboard {
    public static void main(String[] args) {
        // takes a command-line integer n
        int n = Integer.parseInt(args[0]);

        // x- and y-coordinates of the canvas range from 0 and n
        StdDraw.setScale(0, n);

        boolean color;

        for (int i = 0; i < n; i++) {
            color = i % 2 == 0;
            for (int j = 0; j < n; j++, color = !color) {
                if (color) {
                    // blue
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else {
                    // light gray
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }

                // draw each of the n^2 squares
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
