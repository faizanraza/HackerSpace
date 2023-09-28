package com.fraza.algo.etc;

import java.util.Scanner;

public class CommonDivisors {

    public static void main(String[] args) throws Exception
    {
        Scanner s = new Scanner(System.in);
        String ints[] = s.nextLine().split(" ");
        long t1 = System.nanoTime();
        if( ints.length == 2 )
        {
            int count = commDiv(Integer.parseInt(ints[0]), Integer.parseInt(ints[1]));
            System.out.println( "count(divisors) = " + count );
        }
        else System.out.println("illegal input");

        System.out.println("Time taken (sec) = " + (System.nanoTime()-t1)/1000000000d);
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a,a);
    }

    static int commDiv(int a,int b)
    {
        int m = Math.min(a, b);
        // find gcd of a,b
        int n = gcd(a, b);
        System.out.println("gcd = " + n);
        int sqrt = (int) Math.sqrt(n);
        System.out.println("sqfrt(gcd) = " + sqrt);

        // Count divisors of n.
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=sqrt; i++)
        {
            // if 'i' is factor of n
            if (n%i==0)
            {
                sb.append( i + " " );
                // check if divisors are equal
                if (n/i == i) {
                    result += 1;
                }
                else {
                    result += 2;
                    sb.append( m/i + " " );
                }
            }
        }
        System.out.println("divisors = " + sb.toString());
        return result;
    }
}