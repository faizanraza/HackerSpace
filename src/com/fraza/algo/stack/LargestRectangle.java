package com.fraza.algo.stack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/largest-rectangle/problem
//example - 8/1 3 6 8 7 2 4 1 (ans = 18)
//example - 5/1 3 5 9 11 (ans = 18)
//example - 5/11 11 10 10 10 (ans = 50)
public class LargestRectangle {

    static long largestRectangle(int[] h)
    {
        long largest = 0;
        Stack<int[]> s = new Stack<int[]>();

        for( int i=0; i<h.length; ++i )
        {
            int prev = s.isEmpty()? 0 : h[ s.peek()[0]];//current top of stack

            if( h[i] >= prev )
            {
                for( int[] item : s )//add to each item
                {
                    item[1] += h[item[0]];
                }
                s.push( new int[]{i, h[i]}); //TODO - should we look back
            }
            else
            {
                while( !s.isEmpty() )//pop all bigger ones
                {
                    int[] top = s.peek();
                    if( h[top[0]] >= h[i] )
                    {
                        largest = top[1] > largest ? top[1] : largest; //set largest
                        s.pop();
                    }
                    else break;
                }
                for( int[] item : s )//add to rest of the items
                {
                    item[1] += h[item[0]];
                }

                int m = s.isEmpty() ? i+1 : i-s.peek()[0];
                s.push( new int[]{i, h[i]*m});//add new item
            }
        }
        while( !s.isEmpty() )
        {
            int[] top = s.pop();
            largest = top[1] > largest ? top[1] : largest; //set largest
        }
        return largest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
