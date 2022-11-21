public class Minesweeper {
    public static void main(String[] args) {
        // takes three integer command-line arguments m, n, and k
        int m = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]), k = Integer
                .parseInt(args[2]);
        // create the cells without mines
        boolean[][] cells = new boolean[m][n];

        // place the mines
        for (int mine = 0; mine < k; ) {
            int x = (int) (m * Math.random()), y = (int) (n * Math.random());
            if (!cells[x][y]) {
                cells[x][y] = true;
                mine++;
            }
        }

        // prints an m-by-n grid of cells with k mines
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // a mine
                if (cells[i][j]) {
                    System.out.print("*  ");
                }
                // check 3 by 3 area
                else {
                    int mines = 0;
                    for (int checkX = Math.max(0, i - 1); checkX <= i + 1 && checkX < m; checkX++) {
                        for (int checkY = Math.max(0, j - 1); checkY <= j + 1 && checkY < n;
                             checkY++) {
                            if (cells[checkX][checkY]) mines++;
                        }
                    }
                    System.out.print(mines+"  ");
                }
            }
            System.out.println();
        }
    }
}
