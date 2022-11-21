/*package sortingArrays;

public class MergeSort {
    public static <E extends Comparable<E>> void sort(E[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {   // sort a[lo, hi)
        if (hi - lo <= 1) return;
        int mid = (lo + hi) >> 1;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++)
        {
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        for (int k = lo; k < hi; k++) a[k] = aux[k];
    }
}
*/