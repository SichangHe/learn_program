public class WorldMap {
    public static void main(String[] args) {
        // first line contains two integers: width and height
        int width = StdIn.readInt(), height = StdIn.readInt();

        // Call StdDraw.setCanvasSize() to set the size of the canvas to be width-by-height pixels.
        // Call StdDraw.setXscale() and StdDraw.setYscale() so that x-coordinates of the canvas range from 0 to width and the y-coordinates range from 0 to height.
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // increace performance
        StdDraw.enableDoubleBuffering();

        // The first entry in each region is the name of the region. For simplicity, names will not contain spaces.
        // The next entry is an integer specifying the number of vertices in the polygon describing the region.
        // Finally, the region contains the x- and y-coordinates of the vertices of the polygon.
        int vertices;
        while (!StdIn.isEmpty()) {
            StdIn.readString();
            vertices = StdIn.readInt();
            double[] x = new double[vertices], y = new double[vertices];
            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
