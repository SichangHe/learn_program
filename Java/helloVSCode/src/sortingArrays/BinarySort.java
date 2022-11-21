/**
 * <copyright>Steven He 2021</copyright>
 */

package sortingArrays;

import java.util.ArrayList;
import java.util.List;

public class BinarySort
{
    public static <E extends Comparable<E>> void sort(E[] a)
    {   // construct a new list array
        List<E> b = new ArrayList<E>();
        // define the variables we will need
        int lo, hi, mid, cmp, alength = a.length;
        E ai;
        // add the first element
        b.add(a[0]);
        // add elements one by one
        for (int i = 1; i < alength; i++)
        {   // i = 1 ~ (a.length - 1)
            ai = a[i];
            if (b.get(0).compareTo(ai) < 0)
            {   // find out the place for the new element and add it
                lo = 0;
                hi = i;     // = b.size()
                do
                {   // loop until we find the place
                    if (hi - lo <= 1)
                    {   // we have found the place, insert ai to index hi
                        b.add(hi, ai);
                        break; }
                    // set the mid point
                    mid = (lo + hi) >> 1;
                    // compare the middle point and the new element
                    cmp = b.get(mid).compareTo(ai);
                    if (cmp > 0)
                    {   // the new element should be put before mid, in [lo, mid)
                        hi = mid;
                    }
                    else
                    {   // the new element should be put after mid, in [mid, hi)
                        lo = mid; }
                }while (true);
            }
            else
            {   // the new element should be added to the first place
                b.add(0, ai); }
        }
        // copy b to a
        for (int i = 0; i < alength; i++) a[i] = b.get(i);
    }
}
