public class SelfAvoidingWalk {
    public static void main(String[] args) {
        // Do trials random self-avoiding
        // walks in an n-by-n lattice.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double deadEnds = 0;
        double lengthEscape = 0;
        double lengthDeadEnds = 0;
        double AreaDeadEnds = 0;
        //repeat trials
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2, xmin = n / 2, xmax = n / 2, ymin = n / 2, ymax = n / 2;
            //count from length = 0
            for (int length = 0; ; ) {
                //when in border
                if (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
                    a[x][y] = true;
                    //when dead
                    if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                        deadEnds++;
                        lengthDeadEnds += length;
                        AreaDeadEnds += (xmax - xmin) * (ymax - ymin);
                        break;
                    }
                    //not dead, move
                    double r = Math.random();
                    if (r < 0.25) {
                        if (!a[x + 1][y]) {
                            x++;
                            xmax = Math.max(xmax, x);
                            length++;
                        }
                    } else if (r < 0.50) {
                        if (!a[x - 1][y]) {
                            x--;
                            xmin = Math.min(xmin, x);
                            length++;
                        }
                    } else if (r < 0.75) {
                        if (!a[x][y + 1]) {
                            y++;
                            ymax = Math.max(ymax, y);
                            length++;
                        }
                    } else if (r < 1.00) {
                        if (!a[x][y - 1]) {
                            y--;
                            ymin = Math.min(ymin, y);
                            length++;
                        }
                    }
                }
                //escape
                else {
                    lengthEscape += length;
                    break;
                }
            }//where break to
        }
        System.out.println(n + " by " + n + " lattice, " + trials + " trails");
        System.out.println(100 * deadEnds / trials + "% dead ends");
        System.out.println("average escape length " + lengthEscape / (trials - deadEnds));
        System.out.println("average dead end length " + lengthDeadEnds / deadEnds);
        System.out.println("average dead end area " + AreaDeadEnds / deadEnds);
    }
}