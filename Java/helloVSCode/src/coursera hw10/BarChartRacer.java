import java.util.Arrays;

public class BarChartRacer {

    public static void main(String[] args) {

        // the name of a bar-chart-racer file and an integer k that specifies how many bars to display in each bar chart
        String file = args[0];
        int k = Integer.parseInt(args[1]);

        // read the file
        In in = new In(file);
        String title = in.readLine(),
                xAxisLabel = in.readLine(),
                dataSource = in.readLine(),
                line;

        BarChart chart = new BarChart(title, xAxisLabel, dataSource);

        String[] rawData;

        int numRecord;

        Bar[] rawChart;

        // ready to draw
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // has group
        while (in.hasNextLine()) {

            // consume the blank line
            in.readLine();

            // how many records in the group
            numRecord = Integer.parseInt(in.readLine());

            // read raw data into ArrayList rawChart
            // special case for first one
            rawChart = new Bar[numRecord];
            line = in.readLine();

            rawData = line.split(",", 5);

            chart.setCaption(rawData[0]);

            rawChart[0] = new Bar(rawData[1], Integer.parseInt(rawData[3]), rawData[4]);

            // numRecord lines in total
            for (int i = 1; i < numRecord; i++) {
                line = in.readLine();
                rawData = line.split(",", 5);

                rawChart[i] = new Bar(rawData[1], Integer.parseInt(rawData[3]), rawData[4]);
            }

            // sort rawChart
            Arrays.sort(rawChart);

            // assign the values to chart
            for (int i = numRecord - 1; i >= numRecord - k; i--) {
                chart.add(rawChart[i].getName(), rawChart[i].getValue(), rawChart[i].getCategory());
            }

            // show the graph
            // draw the bar chart
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(40);

            // reset barChart
            chart.reset();
        }
    }
}
