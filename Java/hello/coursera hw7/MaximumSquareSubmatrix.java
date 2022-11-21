public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix of a[][] containing only 1s.
    public static int size(int[][] a) {
        // counter
        int counter = 0;

        // make an array to store max square submatrix top left cornered on the element
        int[][] mss = new int[a.length][a.length];

        // temporary value
        int temp = -1;

        // set the last roll
        for (int j = a.length -1; j >= 0; j--) {                        // mss[a.length -1][a.length -1] ~ mss[a.length -1][temp + 1]
            if (a[a.length -1][j] == 1) {                               // non empty
                counter = 1;
                mss[a.length -1][j] = 1;
                temp = j -1;
                break;
            }
        }
        // the version without setting counter
        for (int j = temp; j >= 0; j--) {                               // mss[a.length -1][temp] ~ mss[a.length -1][0]
            if (a[a.length -1][j] == 1) {                               // non empty
                mss[a.length -1][j] = 1;
            }
        }

        // fill the last column
        if (counter == 0) {                                             // need set counter
            // the version with setting counter
            for (int i = a.length - 2; i >= 0; i--) {                   // mss[a.length -2][a.length -1] ~ mss[temp + 1][a.length -1]
                if (a[i][a.length - 1] == 1) {                          // non empty
                    counter = 1;
                    mss[i][a.length - 1] = 1;
                    temp = i -1;
                    break;
                }
            }
        }
        else temp = a.length - 2;

        // the version without setting counter
        for (int i = temp; i >= 0; i--) {                               // mss[temp][a.length -1] ~ mss[0][a.length -1]
            if (a[i][a.length - 1] == 1) {                              // non empty
                mss[i][a.length - 1] = 1;
            }
        }

        // read the rest and decide MSS based on neighbouring elements
        for (int i = a.length -2; i >= 0; i--) {                        // roll a.length -2 ~ 0
            for (int j = a.length -2; j >= 0; j--) {                    // column a.length -2 ~ 0
                if (a[i][j] == 1) {                                     // non empty
                    mss[i][j] = 1 + Math.min(mss[i + 1][j], Math.min(mss[i][j + 1], mss[i + 1][j + 1]));
                    counter = Math.max(counter, mss[i][j]);
                }
            }
        }

        // return value
        return counter;
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
