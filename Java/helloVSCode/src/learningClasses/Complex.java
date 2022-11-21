package learningClasses;

import java.util.Objects;

public class Complex {
    // instance variable inside the reference type (not final if need to change value)
    private final double x, y;

    // constructor
    /**
     * represent the number as ai + b
     */
    public Complex(double a, double b) {
        x = a;
        y = b;
    }

    /**
     * addition
     */
    public Complex plus(Complex add) {
        return new Complex(x + add.re(), y + add.im());
    }
    /**
     * subtraction
     */
    public Complex minus(Complex minus) {
        return new Complex(x - minus.re(), y - minus.im());
    }
    /**
     * multiplication
     */
    public Complex times(Complex time) {
        return new Complex(x * time.re() - y * time.im(), x * time.im() + y * time.re());
    }
    /**
     * division
     */
    public Complex over(Complex over) {
        return new Complex((x * over.re() + y * over.im()) / abs(), (-y * over.im() + x * over.re()) / abs());
    }
    /**
     * magnitude
     */
    public double abs() {
        return Math.sqrt(x * x + y * y);
    }
    /**
     * conjunction
     */
    public Complex conjunct() {
        return new Complex(x, -y);
    }
    /**
     * real part
     */
    public double re() {
        return x;
    }
    /**
     * imaginary part
     */
    public double im() {
        return y;
    }
    /**
     * convert to String
     */
    public String toString() {
        return x + " + " + y + "i";
    }

    public boolean equals(Object object)
    {
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        Complex that = (Complex) object;
        return (this.x == that.x) && (this.y == that.y);
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Complex a = new Complex(3, 4);
        Complex b = new Complex(-2, 3);
        System.out.println("a = " + a.toString() + ", b = " + b.toString());
        System.out.println("a + b = " + a.plus(b).toString() + ", a * b = " + a.times(b).toString());
        System.out.println("|a| = " + a.abs() + ", |b| = " + b.abs());
    }
}
