package com.fraza.test;

import java.util.Iterator;
import java.util.TreeMap;

import com.fraza.leetcode.MergeMultipleLiskedList;
import com.fraza.leetcode.MergeMultipleLiskedList.ListNode;

public class test
{

	public static ListNode mergeKLists(ListNode[] lists) 
	{
		ListNode head = new ListNode();
		
		if(lists.length == 0) return head;
		if(lists.length == 1) return lists[0];

		ListNode iter = head;
		int min = 10001;
		for(ListNode ln: lists)
		{
			if(ln.val < min)
			{
				min = ln.val;
				iter = ln;
				ln = ln.next;
			}
		}
		
		head = iter;

		return head;
	}

	public static void main(String[] args)
	{		
		sample1();
	}

	public static class ListNode 
	{
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static ListNode createLL(int[] arr)
	 {
		 if(arr.length == 0) return null;
		 ListNode next = new ListNode(arr[0]);
		 ListNode prev = next;
		 ListNode head = next;
		 for(int i=1; i<arr.length; ++i)
		 {
			 prev = next;
			 next = new ListNode(arr[i]);
			 prev.next = next;
		 }
		 
		 return head;
	 }
	 
	 public static void printLL(ListNode ll)
	 {
		if(ll == null) System.out.print("[]");
		while(ll != null)
		{
			System.out.print(ll.val + " -> ");
			ll = ll.next;
		}
		System.out.println();
	 }
	 
	 public static void sample1() //1->1->2->3->4->4->5->6
	 {
		int[][] lists = new int[][] {{1,4,5},{1,3,4},{2,6}};
		ListNode[] LLs = new ListNode[lists.length];
		for(int i =0; i<lists.length; ++i )
		{
			int[] list = lists[i];
			ListNode ll = createLL(list);
			LLs[i] = ll;
		}
		ListNode ans = mergeKLists(LLs);
		printLL(ans);
	 }
}
