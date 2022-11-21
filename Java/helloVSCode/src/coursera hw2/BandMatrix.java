public class BandMatrix {
    public static void main(String[] args) {
        // takes two integer command-line arguments n and width
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        // prints an n-by-n pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // with a zero (0) for each element whose distance from the main diagonal is strictly more than width,
                if (Math.abs(i - j) > width) {
                    System.out.print("0  ");
                }
                // and an asterisk (*) for each entry that is not, and two spaces between each 0 or *
                else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
    }
}
