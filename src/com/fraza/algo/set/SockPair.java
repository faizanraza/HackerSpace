package com.fraza.algo.set;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sock-merchant/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class SockPair 
{
	static int sockMerchant(int n, int[] ar) 
	{
		int pairs = 0;
		HashSet<Integer> sockType = new HashSet<Integer>();
		int c;
		for( int i=0; i<n; ++i)
		{
			c = ar[i];
			if( sockType.contains(c) )
			{
				sockType.remove(c);
				pairs++;
			}
			else sockType.add(c);
		}
		return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
