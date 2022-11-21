public class Huntingtons {


    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        // define max
        int max = 0, maxhere, first, check;

        // scan from 0, stop when reach dna.length - 2
        for (int start = 0; start < dna.length() - 2; ) {
            // first CAG from start
            first = dna.indexOf("CAG", start);
            // no more CAG
            if (first == -1) break;
            // at least 1 CAG
            maxhere = 1;
            // check if there are consecutive repeats
            for (check = first + 3; check < dna.length() - 2; check += 3) {
                // there is CAG next to the last one
                if (dna.indexOf("CAG", check) == check) maxhere++;
                // no more CAG counting this way
                else break;
            }
            // update max
            max = Math.max(max, maxhere);
            // update start
            start = check + 1;
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats > 9 && maxRepeats < 36) return "normal";
        if (maxRepeats > 35 && maxRepeats < 40) return "high risk";
        if (maxRepeats > 39 && maxRepeats < 181) return "Huntington's";
        return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // Take the name of a file as a command-line argument.
        String fileName = args[0];

        // Read the genetic sequence from the file using the In class.
        In readSequence = new In(fileName);

        // Remove any whitespace (spaces, tabs, and newlines).
        String cleaned = removeWhitespace(readSequence.readAll());

        // Count the number of CAG repeats.
        int count = maxRepeats(cleaned);
        System.out.println("max repeats = " + count);

        // Print a medical diagnosis in the format below.
        System.out.print(diagnose(count));

    }
}
