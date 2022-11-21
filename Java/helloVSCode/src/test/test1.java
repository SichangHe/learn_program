package test;

import java.util.Random;

public class test1 {
    public static void main(String[] args)
    {
        StringBuilder a = new StringBuilder();

        for (int i = 0; i < 20; i++)
        {
            Random r = new Random();
            a.append(r.nextInt(10));
        }
        System.out.println(a);
    }
}
