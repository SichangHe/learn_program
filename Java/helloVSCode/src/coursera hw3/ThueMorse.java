public class ThueMorse {
    public static void main(String[] args) {
        // takes an integer command-line argument n
        int n = Integer.parseInt(args[0]);

        boolean[] thueMorseSequence = new boolean[n];

        // The Thue–Morse sequence is an infinite sequence of 0s and 1s that is constructed by starting with 0 and successively appending the bitwise negation (interchange 0s and 1s) of the existing sequence.
        for (int i = 0; (int) Math.round(Math.pow(2, i - 1)) < n; // 2^(i - 1) < n
             i++) {
            for (int j = 0; j < (int) Math.round(Math.pow(2, i)) // j < 2^i
                    && (int) Math.round(Math.pow(2, i)) + j < n; // 2^i + j < n
                 j++) {
                thueMorseSequence[(int) Math.round(Math.pow(2, i)) + j] // [2^i + j]
                        = !thueMorseSequence[j];
            }
        }

        // create an n-by-n pattern by printing a + (plus sign) in row i and column j if bits i and j in the sequence are equal, and a - (minus sign) if they are different.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thueMorseSequence[i] == thueMorseSequence[j]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
