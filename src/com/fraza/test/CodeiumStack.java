package com.fraza.test;

public class CodeiumStack
{
	public static void main(String[] args)
	{
		StackTest.main(args);
	}
	
	public static class StackTest
	{
		public static int[] arr = new int[] {5,7,9,13,6,10,4};
		
		public static void main(String[] args)
		{
			int lb[] = new int[arr.length];
			lb[0] = -1;
			for (int i = 1; i < arr.length; i++)
			{
				if (arr[i] > arr[i-1])
				{
					lb[i] = i-1;
				}
				else
				{
					lb[i] = lb[i-1];
				}
			}
		}
	}

}
