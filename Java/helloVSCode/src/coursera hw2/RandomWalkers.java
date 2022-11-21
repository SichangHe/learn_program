public class RandomWalkers {
    public static void main(String[] args) {
        // takes two integer command-line arguments r and trials
        int r = Integer.parseInt(args[0]), trials = Integer.parseInt(args[1]);
        double totalSteps = 0;

        // each of trials independent experiments
        for (int trial = 0; trial < trials; trial++) {
            // treating the starting point as (0, 0)
            int x = 0, y = 0;

            for (; Math.abs(x) + Math.abs(y) < r; totalSteps++) {
                // takes one step in a random direction (either north, east, south, or west), each with probability 25%
                double random = Math.random();
                if (random < 0.25)
                    x++;
                else if (random < 0.5)
                    x--;
                else if (random < 0.75)
                    y++;
                else y--;
            }
        }
        System.out.println("average number of steps = "+totalSteps/trials);
    }
}
