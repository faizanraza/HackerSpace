package com.fraza.leetcode;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) 
	{
		int len1 = nums1.length;
		int len2 = nums2.length;
		int mid = (len1+len2)/2;
		boolean odd = mid == (len1+len2-1)/2;
		if(len1 == 0)
		{
			if(odd) return nums2[mid];
			else return (nums2[mid-1] + nums2[mid])/2d;
		}
		else if(len2 == 0)
		{
			if(odd) return nums1[len1/2];
			else return (nums1[mid-1] + nums1[mid])/2d;
		}
		
		int i=0, j=0;
		double prev = -1000001d;
		double curr = prev;
		while(i+j<=mid)
		{
			if(nums1[i] < nums2[j])
			{
				prev = curr;
				curr = nums1[i];
				if(i == len1-1)
				{
					while(i+j<mid)
					{
						prev = curr;
						curr = nums2[j];
						j++;
					}
					break;
				}
				else
					i++;
			}
			else
			{
				prev = curr;
				curr = nums2[j];
				if(j == len2-1)
				{
					while(i+j<mid)
					{
						prev = curr;
						curr = nums1[i];
						i++;
					}
					break;
				}
				else
					j++;
			}
		}
		//System.out.println(len+"=odd="+odd + " :: i,j=" + i + "," + j + " :: prev,curr = " + prev + "," + curr);
		
		if(odd)
			return curr;
		else
			return (prev+curr)/2d;
	 }
	
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) 
	{
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		int i=0, j=0, mid=(len1+len2-1)/2;
		double prev = 1.1d;
		while(i<len1 && j<len2 && (i+j)<mid)
		{
			if(nums1[i] < nums2[j])
			{
				prev = nums1[i];
				if(i == len1-1)
				{
					//prev = nums1[i];
					j++;
				}
				else 
				{
					//prev = nums2[j];
					i++;
				}
			}
			else
			{
				prev = nums2[j];
				if(j == len2-1)
				{
					//prev = nums2[j];
					i++;
				}
				else 
				{
					//prev = nums1[i];
					j++;
				}
			}
		}
		
		if((len1+len2)/2 == (len1+len2+1)/2) //even
		{
			System.out.println((len1+len2) + " is Even :: " + i + "," + j + " = " + nums1[i] + "," + nums2[j] + " -> prev = " + prev);
//			int m1 = (nums2[j] > nums1[i])? nums1[i] : nums2[j];
//			if(i == len1-1)
//				return (m1 + nums2[j+1])/2d;
//			else if(j == len2-1)
//				return (m1 + nums1[i+1])/2d;
//			else if(nums1[i+1] < nums2[j+1])
//				return (m1 + nums1[i+1])/2d;
//			else
//				return (m1 + nums2[j+1])/2d;
			return (prev + Math.max(nums1[i], nums2[j]))/2d;
		}
		else//odd
		{
			System.out.println((len1+len2) + " is Odd :: " + i + "," + j + " = " + nums1[i] + "," + nums2[j] + " -> prev = " + prev);
			return prev;
		}
	 }
	
	 public static void main(String[] args) throws Exception 
	 {
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 	sample6();
	 }
	
	 public static void sample1()//2
	 {
		int[] nums = {1,3};
		int[] nums2 = {2};
		double ans = new MedianOfSortedArrays().findMedianSortedArrays(nums, nums2);
		System.out.println(ans);
	 }

	 public static void sample2()//(2+3)/2=2.5
	 {
		int[] nums = {1,2};
		int[] nums2 = {3,4};
		double ans = new MedianOfSortedArrays().findMedianSortedArrays(nums, nums2);
		System.out.println(ans);
	 }

	 public static void sample3()//(4+5)/2=4.5
	 {
		int[] nums = {1,2};
		int[] nums2 = {3,4,5,6,7,8};
		double ans = new MedianOfSortedArrays().findMedianSortedArrays(nums, nums2);
		System.out.println(ans);
	 }

	 public static void sample4() //(8+8)/2=8
	 {
		int[] nums = {1,2,5,8,11,13};
		int[] nums2 = {3,6,8,9,10,14};
		double ans = new MedianOfSortedArrays().findMedianSortedArrays(nums, nums2);
		System.out.println(ans);
	 }
	 
	 public static void sample5()//2
	 {
		int[] nums = {};
		int[] nums2 = {2};
		double ans = new MedianOfSortedArrays().findMedianSortedArrays(nums, nums2);
		System.out.println(ans);
	 }
	 
	 public static void sample6()//2.5
	 {
		int[] nums = {2,3};
		int[] nums2 = {};
		double ans = new MedianOfSortedArrays().findMedianSortedArrays(nums, nums2);
		System.out.println(ans);
	 }
}