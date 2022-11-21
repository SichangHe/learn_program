public class ColorHSB {

    // the three instant variables
    private final int h, s, b;

    // Creates a color with hue, saturation, and brightness.
    public ColorHSB(int hue, int saturation, int brightness) {
        // Throw an IllegalArgumentException in the constructor if any component is outside its prescribed range (0 to 359 for the hue, 0 to 100 for the saturation and brightness)
        if (hue < 0 || hue > 359) throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (saturation < 0 || saturation > 100) throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (brightness < 0 || brightness > 100) throw new IllegalArgumentException("the brightness must be between 0 and 100");

        h = hue;
        s = saturation;
        b = brightness;
    }

    /** Returns a string representation of this color (h, s, b).
     *
     * @return String
     */
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    /** Is this color a shade of gray?
     *
     * @return boolean
     */
    public boolean isGrayscale() {
        return (s == 0 || b == 0);
    }

    /** Returns the squared distance between the two colors.
     *
     * @param that
     * @return int
     */
    public int distanceSquaredTo(ColorHSB that) {
        // throw an IllegalArgumentException in distanceSquaredTo() if its argument is null
        if (that == null) throw new IllegalArgumentException("that color cannot be \"null\"");

        return Math.min(
                (this.h - that.h)*(this.h - that.h), (360 - Math.abs(this.h - that.h))*(360 - Math.abs(this.h - that.h))
        )
                + (this.s - that.s)*(this.s - that.s) + (this.b - that.b)*(this.b - that.b);
    }

    public static void main(String[] args) {
        // take three integer command-line arguments h, s, and b
        int h = Integer.parseInt(args[0]), s = Integer.parseInt(args[1]), b = Integer.parseInt(args[2]);
        ColorHSB predefinedColor = new ColorHSB(h, s, b);

        // read a list of pre-defined colors from standard input
        String[] a = StdIn.readAllStrings();
        ColorHSB[] colorFromList = new ColorHSB[a.length / 4];

        // find the color closest to predefined color
        // initialize min for the distance and its index
        colorFromList[0] = new ColorHSB(Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]));
        int min = colorFromList[0].distanceSquaredTo(predefinedColor);
        int indexOfMin = 0;

        // update min and index through the rest of the colors
        for (int i = 1; i < colorFromList.length; i++) {
            colorFromList[i] = new ColorHSB(Integer.parseInt(a[1 + 4*i]), Integer.parseInt(a[2 + 4*i]), Integer.parseInt(a[3 + 4*i]));
            int distance = colorFromList[i].distanceSquaredTo(predefinedColor);

            // update min and index if needed
            if (distance < min) {
                min = distance;
                indexOfMin = i;
            }
        }

        // the name of the nearest pre-defined color and the string representation of that color, separated by whitespace
        System.out.print(a[4*indexOfMin] + " " + colorFromList[indexOfMin]);
    }
}
