package com.fraza.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class TBD
{
	public static int[] arr = new int[] {5,7,9,13,6,10,4};
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		int lb[] = new int[arr.length];
		st.push(0);
		lb[0] = -1;
		for (int i = 1; i < arr.length; i++)
		{
			while (st.size() > 0 && arr[i] < arr[st.peek()])
			{
				st.pop();
			}
			if (st.size() == 0)
			{
				lb[i] = -1;
			}
			else
			{
				lb[i] = st.peek();
			}
			st.push(i);
		}
	}

}
