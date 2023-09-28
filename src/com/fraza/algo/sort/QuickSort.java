package com.fraza.algo.sort;

/*
 * It finds a pivot such that the array on the left is smaller and on the right is greater
 * Start with last element as pivot 
 * Bring the pivot to a position such that left is smaller and right is greater
 * Quick sort the left part, then quick sort the right part recursively 
 * 
 * Space complexity is O(1) as no extra space needed
 * Time complexity nlog(n) worst case n^2
 */
public class QuickSort
{
   void quickSort(int arr[])
   {
   	quickSort(arr, 0, arr.length - 1);
   }

   void quickSort(int arr[], int iStart, int iPivot)
   {
//   	if(iPivot <= iStart) return;
   	int iSmall = iStart - 1;
   	int pivot = arr[iPivot];
   	for(int i=iStart; i<iPivot; i++)
   	{
   		if(arr[i] < pivot)
   		{
   			iSmall++;
   			int temp = arr[i];
   			arr[i] = arr[iSmall];
   			arr[iSmall] = temp;
   		}
   	}
   	//swap the pivot
   	if(iPivot != iSmall + 1)
   	{
   		int temp = arr[iPivot];
   		arr[iPivot] = arr[iSmall+1];
   		arr[iSmall+1] = temp;
   	}
		
		if(iSmall > iStart && iSmall < iPivot) quickSort(arr, iStart, iSmall);
		if(iSmall + 2 > 0 && iSmall + 2 < iPivot) quickSort(arr, iSmall + 2, iPivot);
   }

   /* Prints the array */
   void printArray(int arr[])
   {
       int n = arr.length;
       for (int i=0; i<n; ++i)
           System.out.print(arr[i] + " ");
       System.out.println();
   }

   // Driver method to test above
   public static void main(String args[])
   {
       QuickSort ob = new QuickSort();
       int arr[] = {64, 34, 25, 12, 22, 11, 90, -1, 55, 2, 77, 45};
       ob.quickSort(arr);
       System.out.println("Sorted array");
       ob.printArray(arr);
   }
}
