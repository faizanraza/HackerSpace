package com.fraza.algo.queue;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
public class QueueUsingStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Integer> lastAtTop = new Stack<Integer>();

        for (int i = 0; i < n; i++)
        {
            int type = scanner.nextInt();
            if (type == 1)
            {
                lastAtTop.push( scanner.nextInt() );
            }
            else if (type == 2)
            {
                lastAtTop.remove( 0 );
            }
            else if (type == 3)
            {
                System.out.println( lastAtTop.elementAt(0) );
            }
        }
        System.out.println( lastAtTop.size() );
    }
}
