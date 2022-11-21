import java.util.Arrays;

public class Bar implements Comparable<Bar> {

    private final String na, ca;
    private final int va;

    // constructor
    public Bar(String name, int value, String category) {
        if (name == null || value < 0 || category == null) throw new IllegalArgumentException(
                "the name and the category must not be null, and the value must be greater than 0");
        na = name;
        va = value;
        ca = category;
    }

    /**
     * @return name of the bar
     */
    public String getName() {
        return na;
    }

    /**
     * @return value of the bar
     */
    public int getValue() {
        return va;
    }

    /**
     * @return category of the bar
     */
    public String getCategory() {
        return ca;
    }

    /**
     * @param that the other bar you want to compare to
     * @return int difference between the two bars
     */
    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException("the bar cannot be null");
        return this.va - that.va;
    }

    // test
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
    }
}
