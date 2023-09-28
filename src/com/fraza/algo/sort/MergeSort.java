package com.fraza.algo.sort;

/*
 * Split the array into 2 halves
 * Continue to do this until you get one element in each array
 * merge the 2 arrays keeping the order
 * 
 * Space complexity is nlog(n) as each step creates a new set of arrays
 * Time complexity nlog(n) worst case n^2 (multiple swaps)
 */
public class MergeSort
{

	public static int[] mergesort(int[] arr, int lo, int hi)
	{
		if (lo == hi)
		{
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}

		int mid = (lo + hi) / 2;
		int arr1[] = mergesort(arr, lo, mid);
		int arr2[] = mergesort(arr, mid + 1, hi);
		return merge(arr1, arr2);
	}

	public static int[] merge(int[] arr1, int[] arr2)
	{
		int i = 0, j = 0, k = 0;
		int n = arr1.length;
		int m = arr2.length;
		int[] arr3 = new int[m + n];
		while (i < n && j < m)
		{
			if (arr1[i] < arr2[j])
			{
				arr3[k] = arr1[i];
				i++;
			}
			else
			{
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < n)
		{
			arr3[k] = arr1[i];
			i++;
			k++;
		}

		while (j < m)
		{
			arr3[k] = arr2[j];
			j++;
			k++;
		}

		return arr3;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int arr[] = { 2, 9, 8, 3, 6, 4, 10, 7 };
		int[] so = mergesort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++)
			System.out.print(so[i] + " ");
	}
	
}
