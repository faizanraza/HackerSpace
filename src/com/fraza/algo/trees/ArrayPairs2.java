package com.fraza.algo.trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/array-pairs/problem
//TC2output=119445
public class ArrayPairs2 {

    static long solve(int[] arr) {

        long count = 0;
        int n = arr.length;
        for( int i=0; i<n-1; i++ )
        {
            int j=i+1;
            if( arr[i] == 1 ||  arr[j] == 1 ) count++;

            int max = arr[i] >= arr[j] ? arr[i] : arr[j];
            for( j++; j<n; j++ )
            {
                if( arr[j] > max ) max = arr[j];

                long mul = arr[i]* (long)arr[j];
                if( mul <= max ) count++;
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

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
