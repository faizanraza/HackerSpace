package com.fraza.test;

public class test
{

	public static void main(String[] args)
	{
		int[] arr =
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 5 };
		int n = 10;
		int count = 0;
		Math.max(n, count);
		long t1 = System.nanoTime();
		long t2 = System.nanoTime();
		for (int i = 0; i < n - 1; i++)
		{
			int j = i + 1;
			t1 = System.nanoTime();
			int max = Math.max(arr[i], arr[j]);
			t2 = System.nanoTime();
			System.out.println(i + "," + j + " - " + (t2 - t1) / 1000d);

			t1 = System.nanoTime();
			if (arr[i] == 1 || arr[j] == 1) count++;
			System.out.println(i + "," + j + " - " + (System.nanoTime() - t1) / 1000d);

			for (j++; j < n; j++)
			{
				t1 = System.nanoTime();
				max = Math.max(max, arr[j]);
				if (arr[i] * arr[j] <= max) count++;
				System.out.println(i + "," + j + " - " + (System.nanoTime() - t1) / 1000d);
			}
		}
	}
}
