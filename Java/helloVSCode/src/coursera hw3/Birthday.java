public class Birthday {
    public static void main(String[] args) {
        // takes two integer command-line arguments n and trials
        int n = Integer.parseInt(args[0]), trials = Integer.parseInt(args[1]);
        // record the times that number of people entered
        int[] times = new int[n + 2], totalTimes = new int[n + 2];
        // calculate the fractions of times
        double[] fraction = new double[n + 2];

        // performs the following experiment trials times
        for (int trial = 0; trial < trials; trial++) {
            // each trial
            // record which birthday is recorded
            boolean[] birthdays = new boolean[n];
            for (int i = 1; ; i++) {
                // Choose a birthday for person i, uniformly at random between 0 and n−1.
                int birthday = (int) (n * Math.random());
                // If person i shares a birthday, stop; otherwise repeat.
                if (birthdays[birthday]) {
                    times[i]++; // i people entered
                    break;
                }
                else {
                    birthdays[birthday] = true;
                }

            }
            // end of each trial
        }

        // Print a table that summarizes the results
        for (int i = 1; fraction[i - 1] < 0.5; i++) {
            System.out.print(i + "\t");
            // less that i people counts as i people
            totalTimes[i] = times[i] + totalTimes[i - 1];
            System.out.print(times[i] + "\t");
            fraction[i] = (double) totalTimes[i] / trials;
            System.out.println(fraction[i]);
        }
    }
}
