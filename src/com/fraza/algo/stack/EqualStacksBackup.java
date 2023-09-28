package com.fraza.algo.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/equal-stacks/problem
public class EqualStacksBackup {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> s1 = new Stack<Integer>();int s1sum = 0;
        Stack<Integer> s2 = new Stack<Integer>();int s2sum = 0;
        Stack<Integer> s3 = new Stack<Integer>();int s3sum = 0;

        int maxLen = Math.max(Math.max(h1.length, h2.length), h3.length);
        for( int i=maxLen-1; i>=0; i--)
        {
            if( h1.length > i )
            {
                s1.push( h1[i] );
                s1sum += h1[i];
            }
            if( h2.length > i )
            {
                s2.push( h2[i] );
                s2sum += h2[i];
            }
            if( h3.length > i )
            {
                s3.push( h3[i] );
                s3sum += h3[i];
            }
        }

        while( !s1.isEmpty() && !s2.isEmpty()  && !s3.isEmpty() )
        {
            if( s1sum == s2sum && s1sum == s3sum )
            {
                break;
            }
            else if( s1sum > s2sum && s1sum > s3sum )
            {
                s1sum -= s1.pop();
            }
            else if( s2sum > s1sum && s2sum > s3sum )
            {
                s2sum -= s2.pop();
            }
            else if( s3sum > s1sum && s3sum > s2sum )
            {
                s3sum -= s3.pop();
            }
        }

        return ( s1sum == s2sum && s1sum == s3sum ) ? s1sum : 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = n1-1; h1Itr >= 0; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = n2-1; h2Itr >= 0; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = n3-1; h3Itr >= 0; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
