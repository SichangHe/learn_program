public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

        // approximate ceiling
        int l = (int) Math.cbrt((double) n / 2.0 - 1) + 1;

        // use long to store current cube
        long cube;

        // use int to store number of solution
        int solution = 0;

        // calculate those n
        for (int i = 1; i < l; i++) {
            cube = (long) i * i * i;
            int floor = (int) Math.cbrt((double) n - cube);
            if (cube + (long) floor * floor * floor == n) {
                solution++;

                if (solution == 2) return true;
            }
            else {
                if (cube + (long) (floor + 1) * (floor + 1) * (floor + 1) == n) {
                    solution++;

                    if (solution == 2) return true;
                }
            }
        }

        return false;
    }

    // Takes a long integer command-line arguments n and prints true if n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
