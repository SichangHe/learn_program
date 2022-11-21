// involves real-valued functions
// compute various activation functions that arise in neural networks
// An activation function is a function that maps real numbers into a desired range, such as between 0 and 1 or between –1 and +1.

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        // All activation functions should return NaN (not a number) if the argument is NaN.
        if (Double.isNaN(x)) return Double.NaN;
        if (x == 0) return 0.5;
        if (x > 0) return 1.0;
        return 0.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        // All activation functions should return NaN (not a number) if the argument is NaN.
        if (Double.isNaN(x)) return Double.NaN;
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        // All activation functions should return NaN (not a number) if the argument is NaN.
        if (Double.isNaN(x)) return Double.NaN;
        if (x >= 20) return 1.0;
        if (x <= -20) return -1.0;
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        // All activation functions should return NaN (not a number) if the argument is NaN.
        if (Double.isNaN(x)) return Double.NaN;
        if (Double.isInfinite(x)) {
            if (x > 0) return 1.0;
            else return -1.0;
        }
        return x / (1.0 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        // All activation functions should return NaN (not a number) if the argument is NaN.
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) return -1.0;
        if (x > -2 && x < 0) return x + x * x / 4.0;
        if (x >= 0 && x < 2) return x - x * x / 4.0;
        return 1.0;
    }

    // Takes a double command-line argument x and prints each activation function, evaluated.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("  sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("     tanh(" + x + ") = " + tanh(x));
        StdOut.println(" softsign(" + x + ") = " + softsign(x));
        StdOut.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
