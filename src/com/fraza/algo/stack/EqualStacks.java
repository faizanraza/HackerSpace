package com.fraza.algo.stack;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/equal-stacks/problem
//TC4 output = 1656086
public class EqualStacks {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        int sum=0;
        for( int i=h1.length-1; i>=0; i-- )
        {
            sum += h1[i];
            s1.push( sum );
        }
        sum=0;
        for( int i=h2.length-1; i>=0; i-- )
        {
            sum += h2[i];
            s2.push( sum );
        }
        sum=0;
        for( int i=h3.length-1; i>=0; i-- )
        {
            sum += h3[i];
            s3.push( sum );
        }

        if( (h1.length <= h2.length && h1.length <= h3.length) )
        {
            while (!s1.isEmpty())
            {
                int maxheight = s1.pop();
                if (s2.contains(maxheight) && s3.contains(maxheight))
                    return maxheight;
            }
        }
        if( (h2.length <= h1.length && h2.length <= h3.length) )
        {
            while (!s2.isEmpty())
            {
                int maxheight = s2.pop();
                if (s1.contains(maxheight) && s3.contains(maxheight))
                    return maxheight;
            }
        }
        if( (h3.length <= h1.length && h3.length <= h1.length) )
        {
            while (!s3.isEmpty())
            {
                int maxheight = s3.pop();
                if (s1.contains(maxheight) && s2.contains(maxheight))
                    return maxheight;
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        System.out.println( "t1 = " + (System.currentTimeMillis() - t1)/1000d );
        int result = equalStacks(h1, h2, h3);
        System.out.println( "t1+t2 = " + (System.currentTimeMillis() - t1)/1000d );

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
