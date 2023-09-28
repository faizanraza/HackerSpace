package com.fraza.test;

public class Main
{

	// public static int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	// public static int[] b = {1, 3, 7};
	public static int[] a =
	{};
	public static int[] b =
	{};
	public static int[] c;

	public static void main(String[] args)
	{
		m2();
		printArr();
	}

	public static void m1()
	{
		int k = 0;
		int i = 0;
		int j = b[k];
		i = j + 1;

		while (i < a.length)
		{
			if (b[k] != i)
			{
				a[j] = a[i];
				j++;
			}
			else k++;
			i++;
		}

	}

	public static void m2()
	{
		c = new int[a.length - b.length];
		int ib = 0;
		int ia = 0;
		int ic = 0;

		while (ia < a.length)
		{
			if (ib == b.length || ia < b[ib])
			{
				c[ic++] = a[ia++];
			}
			else
			{
				ia++;
				ib++;
			}
		}
	}

	public static void printArr()
	{
		for (int i : c)
		{
			System.out.print(i + ",");
		}

		if (c.length == 0) System.out.print("No data left");
	}
}
