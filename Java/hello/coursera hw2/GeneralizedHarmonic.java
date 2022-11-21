public class GeneralizedHarmonic {
    public static void main(String[] args) {

        // n is a positive integer, r is an integer
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double generalizedHarmonicNumbers = 0;

        // compute the nth generalized harmonic number of order r
        for (int i = 1; i<=n; i++){
            generalizedHarmonicNumbers += 1 / (Math.pow(i, r));
        }
        System.out.println(generalizedHarmonicNumbers);
    }
}
