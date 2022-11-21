/*package StdPlayImplementations;

public class numberedMusicNotationReader {
    public static void main(String[] args) {
        // 0 for A, 2 for B, etc. -32 for pause. format: pitch beat
        int SAMPLING_RATE = 44100;
        double
                // first input speed
                speed = Double.parseDouble(args[0]),
                duration,
                pitch,
                frequencyA = 2 * Math.PI * 440 / SAMPLING_RATE;
        double[] a;

        while (!StdIn.isEmpty()) {
            // Read and play one note.
            pitch = StdIn.readDouble();
            duration = 60.0 / speed * StdIn.readDouble();
            int n = (int) (SAMPLING_RATE * duration);
            a = new double[n + 1];
            for (int i = 0; i <= n; i++)
                a[i] = Math.sin(frequencyA * i * Math.pow(2, pitch / 12.0));
            StdAudio.play(a);
        }
    }
}
*/