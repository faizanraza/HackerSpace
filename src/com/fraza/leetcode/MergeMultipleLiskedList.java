package com.fraza.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeMultipleLiskedList
{
	public static class ListNode 
	{
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode mergeKLists(ListNode[] lists) 
	{
		if(lists.length == 0) return null;
		if(lists.length == 1) return lists[0];

		ListNode head = new ListNode();
		ListNode iter = head;
		while(true)
		{
			int min = 10001;
			int index = -1;
			int size = lists.length;
			for(int i=0; i<size; ++i)
			{
				if(null != lists[i] && lists[i].val < min)
				{
					min = lists[i].val;
					index = i;
				}
			}
			if(index != -1)
			{
				iter.next = lists[index];
				iter = iter.next;
				lists[index] = lists[index].next;
			}
			else break;
		}

		return head.next;
    }

	public ListNode mergeKLists1(ListNode[] lists) 
	{
		if(lists.length == 0) return null;
		if(lists.length == 1) return lists[0];

		ListNode head = new ListNode();
		ListNode iter = head;
		List<ListNode> listArr = new ArrayList<ListNode>(Arrays.asList(lists));
		while(true)
		{
			int min = 10001;
			int index = -1;
			int size = listArr.size();
			int[] removals = new int[size];
			for(int i=0; i<size; ++i)
			{
				ListNode ln = listArr.get(i);
				if(null == ln)
				{
					removals[i] = -1;
				}
				else if(ln.val < min)
				{
					min = ln.val;
					index = i;
				}
			}
			if(index != -1)
			{
				iter.next = listArr.get(index);
				iter = iter.next;
				listArr.set(index, listArr.get(index).next);
			}
			else break;
			for(int i=size-1; i>=0; --i)
			{
				if(removals[i] == -1)
					listArr.remove(i);
			}
		}
		iter.next = listArr.get(0);

		return head.next;
    }
	
	public static void main(String[] args) throws Exception 
	{
		long t1 = System.currentTimeMillis();
		sample1();
		sample2();
		sample3();
		sample4();
		sample5();
		sample6();
		System.out.println("Time = "+ (System.currentTimeMillis() - t1));
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
		ListNode ans = new MergeMultipleLiskedList().mergeKLists(LLs);
		printLL(ans);
	 }

	 public static void sample2() //[]
	 {
		ListNode[] LLs = new ListNode[0];
		ListNode ans = new MergeMultipleLiskedList().mergeKLists(LLs);
		printLL(ans);
	 }

	 public static void sample3() //[[]]
	 {
		ListNode[] LLs = new ListNode[1];
		LLs[0] = createLL(new int[0]);
		ListNode ans = new MergeMultipleLiskedList().mergeKLists(LLs);
		printLL(ans);
	 }
	 
	 public static void sample4() //1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 5 -> 6 -> 6 -> 7 -> 8 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 15 -> 17 -> 18
	 {
		int[][] lists = new int[][] {{1,4,5,6,8,10,12},{1,3,4,5,7,8,9,11,13,15,17,18},{2,6}};
		ListNode[] LLs = new ListNode[lists.length];
		for(int i =0; i<lists.length; ++i )
		{
			int[] list = lists[i];
			ListNode ll = createLL(list);
			LLs[i] = ll;
		}
		ListNode ans = new MergeMultipleLiskedList().mergeKLists(LLs);
		printLL(ans);
	 }

	 public static void sample5() //-1->2
	 {
		int[][] lists = new int[][] {{2},{},{-1}};
		ListNode[] LLs = new ListNode[lists.length];
		for(int i =0; i<lists.length; ++i )
		{
			int[] list = lists[i];
			ListNode ll = createLL(list);
			LLs[i] = ll;
		}
		ListNode ans = new MergeMultipleLiskedList().mergeKLists(LLs);
		printLL(ans);
	 }

	 public static void sample6() //-1->5->6->10->11
	 {
		int[][] lists = new int[][] {{},{-1,5,11},{},{6,10}};
		ListNode[] LLs = new ListNode[lists.length];
		for(int i =0; i<lists.length; ++i )
		{
			int[] list = lists[i];
			ListNode ll = createLL(list);
			LLs[i] = ll;
		}
		ListNode ans = new MergeMultipleLiskedList().mergeKLists(LLs);
		printLL(ans);
	 }
}
