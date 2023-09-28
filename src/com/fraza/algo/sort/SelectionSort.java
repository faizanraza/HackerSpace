package com.fraza.algo.sort;

/*
 * Consider array in 2 parts - sorted & non-sorted
 * Select the smallest element from unsorted array and bring it to the beginning
 * increase the length of sorted by 1 and reduce the unsorted by 1
 * 
 * Space complexity is O(1) 
 * Time complexity nlog(n) worst case n^2 (multiple swaps)
 */
public class SelectionSort
{
	public void selectionsort(int array[])
	{
	    int n = array.length;
	    for (int i = 0; i < n-1; i++)
	    {
	        int index = i;
	        int min = array[i];          // taking the min element as ith element of array
	        for (int j = i+1; j < n; j++)
	        {
	            if (array[j] < array[index])
	            {
	                index = j;
	                min = array[j];
	            }
	        }
	        int t = array[index];         //Interchange the places of the elements
	        array[index] = array[i];
	        array[i] = t;
	    }
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
   	 SelectionSort ob = new SelectionSort();
       int arr[] = {64, 34, 25, 12, 22, 11, 90};
       ob.selectionsort(arr);
       System.out.println("Sorted array");
       ob.printArray(arr);
   }
}
