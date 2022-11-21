public class MaximumSquareSubmatrix0 {

    // Returns the size of the largest contiguous square submatrix of a[][] containing only 1s.
    public static int size(int[][] a) {

        // counter
        int counter = 0;

        // array
        int[][][] grouper = new int[a.length][a.length][a.length];

        // special case of n = a.length - 2

        // roll i, n - 1 ~ 0
        for (int i = a.length - 2; i >= 0; i--) {
            // column j, n - 1 ~ 0
            for (int j = a.length - 2; j >= 0; j--) {
                if (a[i][j] == 1 && a[i + 1][j] == 1 && a[i][j + 1] == 1 && a[i + 1][j + 1] == 1) {
                    grouper[a.length - 1][i][j] = 1;
                    counter++;
                }
                else {
                    grouper[a.length - 1][i][j] = 0;
                }
            }
        }
        if (counter == 0) {
            for (int i = a.length - 1; i >= 0; i--) {
                for (int j = a.length - 1; j >= 0; j--) {
                    if (a[i][j] == 1) counter++;
                }
            }
            if (counter == 0) return 0;
            return 1;
        }
        if (counter < 4) return 2;
        counter = 0;

        // the (n + 1)th matrix, (a.length - 1)th ~ 1th
        // (n + 1) by (n + 1) matrix
        for (int n = a.length - 2; n >= 0; n--) {
            // roll i, n - 1 ~ 0
            for (int i = n - 1; i >= 0; i--) {
                // column j, n - 1 ~ 0
                for (int j = n - 1; j >= 0; j--) {
                    // a 2x2 square of 1s
                    if (grouper[n + 1][i][j] == 1 && grouper[n + 1][i + 1][j] == 1
                            && grouper[n + 1][i][j + 1] == 1 && grouper[n + 1][i + 1][j + 1] == 1) {
                        grouper[n][i][j] = 1;
                        counter++;
                    }
                    // not a 2x2 square
                    else {
                        grouper[n][i][j] = 0;
                    }
                }
            }
            // if no 2x2 square
            if (counter == 0) return a.length - n;
            // if no enough 2x2 square for next
            if (counter < 4) return a.length - n + 1;
            counter = 0;
        }
        return a.length;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input and prints the size of the largest contiguous square submatrix containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }

        System.out.println(size(a));

    }
}
