package com.fraza.algo.queue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/truck-tour/problem
public class TruckTour {

    static int truckTour(int[][] petrolpumps) {
        long t1 = System.currentTimeMillis();

        int numPump = petrolpumps.length;
        int i=-1;
        while( ++i < numPump )
        {
            while( petrolpumps[i][0] < petrolpumps[i][1] ) ++i;

            int j=i<numPump-1 ? i+1 : 0;
            int petrol = petrolpumps[i][0] - petrolpumps[i][1];
            while( i != j )
            {
                petrol += petrolpumps[j][0];

                if( petrol < petrolpumps[j][1] ) break;

                petrol -= petrolpumps[j][1];
                j = j<numPump-1 ? j+1 : 0;
            }

            if( i==j ) break;
        }

        System.out.println( "t1 = " + (System.currentTimeMillis() - t1)/1000d );
        return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
