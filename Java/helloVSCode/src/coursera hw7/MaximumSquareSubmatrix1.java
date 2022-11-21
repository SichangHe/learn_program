/**
 * This code is buggy and slow, therefore given up
 */


public class MaximumSquareSubmatrix1 {

    // Returns the size of the largest contiguous square submatrix of a[][] containing only 1s.
    public static int size(int[][] a) {

        // counter
        int counter = 0;

        // determine how many successive 1s are right to an element
        int[][] right = new int[a.length][a.length];

        // from the top roll to the bottom
        for (int i = 0; i < a.length; i++) {
            // from the right element to the left
            for (int j = a.length - 1; j >= 0; j--) {
                // for the place itself, increase
                right[i][j]++;
                // for the place left to it, increase 1 if not 0, if 0 then stop
                for (int n = j - 1; n >= 0; n--) {
                    if (a[i][n] > 0) right[i][n]++;
                    else break;
                }
            }
        }

        // actually count
        int val;
        boolean fail = false;
        // from the top element to the bottom
        for (int i = 0; i < a.length; i++) {
            // check if there are enough potential vertical space
            if (i + counter < a.length) {
                // from the left element to the right
                for (int j = 0; j < a.length; j++) {
                    // check if there are enough potential horizontal space
                    if (j + counter < a.length) {
                        // check if the value is greater than counter
                        val = right[i][j];
                        if (val > counter) {
                            // check n values beneath it
                            for (int n = val; n > counter; n--) {
                                // if there are enough space beneath
                                if (n + i < a.length) {
                                    for (int k = 1; k <= n; k++) {
                                        if (right[i + k][j] < val) {
                                            fail = true;            // inner break signal
                                            break;
                                        }
                                    }
                                    if (fail) fail = false;         // reset fail
                                    else {
                                        counter = n;                // set counter to the larger
                                        break;                      // no need to check smaller n
                                    }
                                }
                            }
                        }
                    }
                    else break;
                }
            }
            else break;
        }

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
