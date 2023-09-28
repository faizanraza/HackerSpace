package com.fraza.algo.stack;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/simple-text-editor/problem
public class TextEditor {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String s = "";
        Stack<Object> stack = new Stack<Object>();

        for (int i = 0; i < n; i++)
        {
            int type = scanner.nextInt();
            if (type == 1)
            {
                String str = scanner.next();
                stack.push(str.length());
                s+= str;
            }
            else if (type == 2)
            {
                int nchar = scanner.nextInt();

                int l = s.length() - nchar;
                int r = s.length();

                stack.push(s.substring(l, r));
                s = s.substring(0, l);
            }
            else if (type == 3)
            {
                System.out.println(s.charAt(scanner.nextInt() - 1));
            }
            else if (type == 4)
            {
                Object o = stack.pop();
                if (o instanceof Integer)
                {
                    s = s.substring(0, s.length() - Integer.parseInt(o.toString()));
                }
                else
                {
                    s += o.toString();
                }
            }

        }
    }
}