package com.fraza.test;

import java.util.Stack;
public class StackTest
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
