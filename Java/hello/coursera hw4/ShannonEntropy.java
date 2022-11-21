public class ShannonEntropy {
    public static void main(String[] args) {
        // takes a command-line integer m
        int m = Integer.parseInt(args[0]), temp;
        double count = 0;

        int[] x = new int[m + 1];
        double shannonEntropy = 0;

        // input all x
        while (!StdIn.isEmpty()) {
            temp = StdIn.readInt();
            // reads a sequence of integers between 1 and m
            if (temp >= 1 && temp <= m) {
                x[temp]++;
                count++;
            }
        }

        // calculate shannonEntropy
        for (int i = 1; i <= m; i++) {
            if (x[i] != 0) {
                shannonEntropy -= x[i] / count * Math.log(x[i] / count) / Math.log(2);
            }
        }

        // print result
        StdOut.printf("%.4f", shannonEntropy);
    }
}
