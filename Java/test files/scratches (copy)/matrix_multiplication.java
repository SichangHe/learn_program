public class matrix_multiplication {
    public static void main(String[] args) {

        // a, b
        int n = 3;
        double[][] a = {{0.7, 0.2, 0.1}, {0.3, 0.6, 0.1}, {0.5, 0.1, 0.4}};
        double[][] b = {{0.2, 0.3, 0.5}, {0.1, 0.2, 0.1}, {0.1, 0.3, 0.4}};

        // c = a * b
        double[][] c = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Dot product of row i and column j.
                for (int k = 0; k < n; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
        }

        // print c
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}