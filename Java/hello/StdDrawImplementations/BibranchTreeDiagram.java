/*package StdDrawImplementations;

public class BibranchTreeDiagram {
    public static void draw(int n, double x, double y, double l,double penRadius) {
        StdDraw.enableDoubleBuffering();
        if (n==0) {
            // StdDraw.point(x,y);
            return;
        }
        StdDraw.setPenRadius(penRadius);
        StdDraw.line(x, y, x-Math.sqrt(3)/2*l, y-l/2);
        StdDraw.line(x, y, x+Math.sqrt(3)/2*l, y-l/2);
        draw(n-1,x-Math.sqrt(3)/2*l,y-l/2,l/2,penRadius/2);
        draw(n-1,x+Math.sqrt(3)/2*l,y-l/2,l/2,penRadius/2);
        StdDraw.show();
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(800, 800);
        draw(n, 0.5,0.75,0.25,0.05);
    }
}
*/