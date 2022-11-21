public class RevesPuzzle {

    // move n discs form fromPole to toPole using transitionPole
    private static void moves(int n, int discNo, String fromPole, String toPole,
                              String transitionPole) {

        // finish if no disks
        if (n == 0) {
            return;
        }

        // move (n - 1) disks from fromPole to transitionPole using toPole
        moves(n - 1, discNo, fromPole, transitionPole, toPole);

        // move 1 disc from fromPole to toPole
        System.out.println("Move disc " + (n + discNo) + " from " + fromPole + " to " + toPole);

        // move (n - 1) disks from transitionPole to toPole using fromPole
        moves(n - 1, discNo, transitionPole, toPole, fromPole);
    }

    // move n discs from fromPole to toPole using transitionPole1 and transitionPole2
    private static void design(int n, String fromPole, String toPole, String transitionPole1,
                               String transitionPole2) {

        // finish if no disks
        if (n == 0) {
            return;
        }

        // Let k denote the integer nearest to (n + 1 - sqrt{2n + 1}).
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        // Transfer the k smallest disks to transitionPole1.
        design(k, fromPole, transitionPole1, transitionPole2, toPole);

        // move the remaining (n - k) disks to toPole using transitionPole2
        moves(n - k, k, fromPole, toPole, transitionPole2);

        // Transfer the k smallest disks to toPole using fromPole and transitionPole2
        design(k, transitionPole1, toPole, fromPole, transitionPole2);
    }

    public static void main(String[] args) {

        // take 1 command-line argument n
        int n = Integer.parseInt(args[0]);

        // Transfer n disks from A to D using B and C
        design(n, "A", "D", "B", "C");
    }
}
