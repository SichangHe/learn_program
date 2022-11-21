/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Inversions {

/*    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {

        // define the number of inversion
        long inversion = 0;

        // proceed from a[0] to a[n - 1]
        for (int i = 0; i < a.length - 1; i++) {
            // only compare a[i] with the values behind it
            // a[i] and a[j] are inverted if (i < j) and (a[i] > a[j])
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) inversion++;
            }
        }

        return inversion;
    }*/

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {

        // special case of a.length < 2
        if (a.length < 2) return 0;

        // define the number of inversion
        long inversion = 0;

        // create an array to store how many elements found are greater than i
        int[] greater = new int[a.length];

        // this is to avoid comparing the last item with itself
        for (int i = a[a.length - 1] + 1; i < a.length; i++) greater[i]++;

        // only compare a[i] with the values found before
        // from a[a.length - 2] to a[0]
        // numbers found = (a.length - i)
        for (int i = a.length - 2; i >= 0; i--) {
            for (int j = a[i] + 1; j < a.length; j++) greater[j]++;


            // the amount of element found greater than a[i] is the amount of inversions between a[i] and everything on its right
            inversion += greater[a[i]];
        }

        return inversion;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        // create an array in order
        int[] a = new int[n];

        // fill a[] from a[0] to a[n - 1]
        // after potentially filling a[i - 1] and making the remaining k smaller, treat the problem as a new problem
        // that is to fill an array of length (n - i) with indexes from i to (n - 1) and elements 0 ~ (n - i - 1) to create k inversions
        for (int i = 0; i < n; i++) {

            // if (k > n - 1 - i), put element (n - 1 - i) first
            if (k > n - 1 - i) {
                a[i] = n - 1 - i;

                // k is smaller now
                k -= n - 1 - i;
            }

            // if (k <= n - 1 - i)
            else {
                // put (i + k) first
                a[i] = (int) k;

                // put 0 ~ (a[i] - 1) after that, from a[i + 1] to a[i + a[i]]
                for (int j = 0; j < a[i]; j++) {
                    a[i + j + 1] = j;
                }
                // put (a[i] + 1) after that, from a[i + a[i] + 1] to a[n - 1]
                for (int j = i + a[i] + 1; j < n; j++) {
                    a[j] = j - i;
                }
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        // Takes an integer n and a long k as command-line arguments,
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        // prints a permutation of length n with exactly k inversions.
        int[] array = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
