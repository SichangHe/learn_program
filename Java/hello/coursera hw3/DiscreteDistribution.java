public class DiscreteDistribution {
    public static void main(String[] args) {
        // takes an integer command-line argument m
        int m = Integer.parseInt(args[0]);

        // followed by a sequence of positive integer command-line arguments a1,a2,…,an
        int[] a = new int[args.length - 1], S = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            a[i] = Integer.parseInt(args[i+1]);
            for (int j = i; j < args.length - 1; j++) {
                S[j] += a[i];
            }
        }

        // generate a random index i with probability proportional to ai:
        for (int i = 0; i < m; i++) {
            int random = (int) (S[args.length - 2] * Math.random());

            // check random < S[j] and print j + 1
            for (int j = 0; j < args.length - 1; j++) {
                if (random < S[j]) {
                    System.out.print(j + 1 + " ");
                    break;
                }
            }
        }
    }
}
