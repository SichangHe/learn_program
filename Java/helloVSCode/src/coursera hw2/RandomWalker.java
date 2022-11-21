public class RandomWalker {
    public static void main(String[] args) {
        // takes an integer command-line argument r
        int r = Integer.parseInt(args[0]), steps = 0;

        // treating the starting point as (0, 0)
        int x = 0, y = 0;

        for (; Math.abs(x) + Math.abs(y) < r; steps++) {
            // takes one step in a random direction (either north, east, south, or west), each with probability 25%
            System.out.println("(" + x + ", " + y + ")");
            double random = Math.random();
            if (random < 0.25)
                x++;
            else if (random < 0.5)
                x--;
            else if (random < 0.75)
                y++;
            else y--;

        }
        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = "+steps);
    }
}
