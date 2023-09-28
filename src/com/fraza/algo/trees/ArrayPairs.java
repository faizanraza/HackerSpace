package com.fraza.algo.trees;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/array-pairs/problem
//TC2output=119445
public class ArrayPairs {

    static long solve(int[] arr) {

        long count = 0;
        int n = arr.length;
        int max;
        for( int i=0; i<n-1; i++ )
        {
            if(arr[i] == 1)
            {
                count = count + (n-1-i);
                continue;
            }

            int j=i+1;
            if( arr[j] == 1 ) count++;
            max = arr[i] >= arr[j] ? arr[i] : arr[j];

            for( j++; j<n; j++ )
            {
                if( arr[j] > max )
                {
                    max = arr[j];
                    //if( arr[i] == 1 ) count++;
                }
                else
                {
                    if( (arr[i] * (long) arr[j]) <= max ) count++;
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long t1 = System.currentTimeMillis();
        long result = solve(arr);
        System.out.println( ( System.currentTimeMillis() - t1 )/1000d ) ;

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
