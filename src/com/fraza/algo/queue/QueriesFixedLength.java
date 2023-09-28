package com.fraza.algo.queue;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/queries-with-fixed-length/problem
public class QueriesFixedLength {

    static int[] solve(int[] arr, int[] queries) {

        int[] ans = new int[queries.length];
        int n = arr.length;
        int k = 0;
        for( int d : queries )
        {
            int min = 1000000;
            int max = 0;
            for( int i=0; i<=n-d; i++ )
            {
                if( d == 1 )
                {
                    max = arr[i];
                }
                else if( i == 0 || max == arr[i-1] )
                {
                    max = 0;
                    for( int j=i; j<i+d; j++ )
                    {
                        max = Integer.max( max, arr[j] );
                    }
                }
                else
                {
                    max = Integer.max( max, arr[i+d-1] );
                }

                min = Integer.min( min, max );
            }
            ans[k++] = min;
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        int[] queries = new int[q];

        for (int queriesItr = 0; queriesItr < q; queriesItr++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[queriesItr] = queriesItem;
        }

        int[] result = solve(arr, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
