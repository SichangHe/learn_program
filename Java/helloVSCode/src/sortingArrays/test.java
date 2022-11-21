/*package sortingArrays;

public class test
{
    public static void main(String[] args)
    {
        // record the total time used
        long totalTime1 = 0, totalTime2 = 0, startTime, endTime;

        // do it 100000 times
        for (int j = 0; j < 100000; j++)
        {

            // initialize 2 new double array of length 100
            Double a[] = new Double[100];
            Double b[] = new Double[100];

            // randomly assign values to them
            for (int i = 0; i < 100; i++)
            {
                a[i] = 10 * Math.random();
                b[i] = a[i];
            }

            // sort it with MergeSort
            startTime = System.nanoTime();
            MergeSort.sort(a);
            endTime = System.nanoTime();
            // timing
            totalTime1 += (endTime - startTime);

            // sort it with BinarySort
            startTime = System.nanoTime();
            BinarySort.sort(b);
            endTime = System.nanoTime();
            // timing
            totalTime2 += (endTime - startTime);

        }
        System.out.println("Finished 100000 trails");
        System.out.println("Average time for Merge:  " + totalTime1 / 100000);
        System.out.println("Average time for Binary: " + totalTime2 / 100000);

    }
}
*/