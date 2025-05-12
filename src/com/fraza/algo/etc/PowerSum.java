package com.fraza.algo.etc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PowerSum {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) 
    {
    	int comb = 0;
    	int i = (int) Math.floor( Math.pow(X, 1.0/N) );
    	while(i*i >= X/3)
    	{
    		int r = X;
    		int j = i;
    		while( j >= 1 )
    		{
    			int j2 = j*j;
    			if( j2 == r )
    			{
    				comb++;
    				break;
    			}
    			else if( j2 < r )
    			{
    				r = r - j2;
    			}
    			j--;
    		}
    		i--;
    	}
    	return comb;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
