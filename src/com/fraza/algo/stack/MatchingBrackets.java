package com.fraza.algo.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/balanced-brackets/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
public class MatchingBrackets {

    static String isBalanced(String s) {

        char[] str = new char[s.length()];
        int j=0;
        for( int i=0; i<s.length(); i++ )
        {
            char r = s.charAt(i);
            if( r == '(' || r == '[' || r == '{' )
            {
                str[j++] = r;
            }
            else if( r == ')' || r == ']' || r == '}' )
            {
                if(j == 0 ) return "NO";
                char l = str[--j];
                if( (l == '(' &&  r == ')') || (l == '[' &&  r == ']') || (l == '{' &&  r == '}'))
                {
                    str[j] = Character.MIN_VALUE;
                }
                else return "NO";
            }
        }
        return j==0? "YES": "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    static String isBalanced_(String s) {

        char[] str = s.toCharArray();
        for( int i=0; i<str.length; i++)
        {
            if( str[i] == ')' || str[i] == ']' || str[i] == '}' )
            {
                char left;
                switch( str[i] )
                {
                    //case ')' : left = '(';break;
                    case ']' : left = '[';break;
                    case '}' : left = '{';break;
                    default : left = '(';break;
                }
                int l = i-1;
                while( l >= 0 && str[l--] != left );
                if( str[l--] != left ) return "NO";

            }
            //else continue
        }
        return "YES";
    }
}
