/*package StdPlayImplementations;

public class concertA {
    public static void main(String[] args) {
        // concert A
        int SAMPLING_RATE = 44100, duration = 1;
        double[] A = new double[SAMPLING_RATE*duration];
        double frequencyA = 2*Math.PI*440/SAMPLING_RATE;

        for (int i = 0; i < A.length; i++) {
            A[i] = Math.sin(frequencyA*i);
        }
        // pause
        double[] pause = new double[SAMPLING_RATE*duration/2];

        // play A
        StdAudio.play(A);
        StdAudio.play(pause);
        StdAudio.play(A);

    }
}*/