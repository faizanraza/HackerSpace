package com.fraza.algo.etc;

import java.util.Scanner;

public class CommonDivisorCount {

    public static void main(String[] args) throws Exception
    {
        Scanner s = new Scanner(System.in);
        String ints[] = s.nextLine().split(" ");
        if( ints.length == 2 )
        {
            int count = commDiv(Integer.parseInt(ints[0]), Integer.parseInt(ints[1]));
            System.out.println( count );
        }
        else System.out.println("illegal input");
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a,a);
    }

    static int commDiv(int a,int b)
    {
        // find gcd of a,b
        int n = gcd(a, b);
        System.out.println(n);

        // Count divisors of n.
        int result = 0;
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            // if 'i' is factor of n
            if (n%i==0)
            {
                // check if divisors are equal
                if (n/i == i)
                    result += 1;
                else
                    result += 2;
            }
        }
        return result;
    }
}