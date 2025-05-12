package com.fraza.algo.permcomb;

//https://www.hackerrank.com/challenges/sherlock-and-permutations/forum
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int solve(int n, int m) 
    {
    // Write your code here
   	 m--;
   	 int N = m + n;
   	 int max = Math.max(m,n);
   	 int min = Math.min(m,n);

   	 long factN = 1;
   	 
   	 while(N > max || min > 1)
   	 {
   		 while(N > max && factN < Long.MAX_VALUE)
   		 {
   			 factN = factN * N--;
   		 }

   		 while(min > 1)
   		 {
   			 factN = factN/min--;
   		 }
   	 }
   	 
   	 return (int)factN;
    }

}

public class SherlockPermutations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.solve(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

