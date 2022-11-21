public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {

        // check special case
        if (n == 0 && k == 0) {
            return 1;
        }
        if (k < -n || k > n) {
            return 0;
        }

        // set up the 2-dimension array: n_ = 0 ~ n, k_ = -n-1 ~ n+1
        long[][] Trinomial = new long[n + 1][2 * n + 3];

        // n_ == 0 && k_ == 0
        Trinomial[0][n + 1] = 1;

        // n_ = 1 ~ n
        for (int n_ = 1; n_ <= n; n_++) {
            // k_ = -n ~ n
            for (int k_ = 1; k_ <= 2 * n + 1; k_++) {
                Trinomial[n_][k_] = Trinomial[n_ - 1][k_ - 1] + Trinomial[n_ - 1][k_] + Trinomial[n_
                        - 1][k_ + 1];
            }
        }
        return Trinomial[n][k + n + 1];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {

        // takes two integer command-line arguments n and k
        int n = Integer.parseInt(args[0]), k = Integer.parseInt(args[1]);

        System.out.print(trinomial(n, k));
    }
}
