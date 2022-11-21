// considers functions on arrays
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = alpha * a[i];
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - i - 1];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] ab = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            ab[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            ab[a.length + i] = b[i];
        }
        return ab;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        // use p to refer to the longer array, q the shorter
        double[] p, q;
        if (a.length < b.length) {
            p = b;
            q = a;
        }
        else {
            p = a;
            q = b;
        }

        double[] ab = new double[p.length];
        for (int i = 0; i < q.length; i++) {
            ab[i] = p[i] + q[i];
        }
        if (a.length == b.length) return ab;
        for (int i = q.length; i < p.length; i++) {
            ab[i] = p[i];
        }
        return ab;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] b = new double[(int) Math.floor(a.length / alpha)];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[(int) Math.floor(i * alpha)];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        double[] a = StdAudio.read("chimes.wav"),
                b = StdAudio.read("cow.wav"),
                c = StdAudio.read("dialup.wav"),
                d = StdAudio.read("exposure.wav"),
                e = StdAudio.read("piano.wav");
        StdAudio.play(merge(amplify(a, 1.5), reverse(b)));
        StdAudio.play(changeSpeed(c, 2.5));
        StdAudio.play(mix(d, e));
    }
}