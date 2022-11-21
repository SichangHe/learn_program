import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args)
    {
        String champ = "";
        String now;

        for (int i = 1; !StdIn.isEmpty(); i++)
        {
            now = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / i))
            { // replace champ with probability 1/i
                champ = now;
            }
        }

        System.out.println(champ);
    }
}
