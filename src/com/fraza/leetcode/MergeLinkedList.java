package com.fraza.leetcode;

public class MergeLinkedList
{
	public static class ListNode 
	{
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
	{
		ListNode head;
		if(list1 == null || list2 == null)
		{
			if(list1 != null) return list1;
			else return list2;
		}

		if(list2.val < list1.val)
		{
			head = list2;
			list2 = list2.next;
		}
		else
		{
			head = list1;
			list1 = list1.next;
		}
		ListNode iter = head;
		
		while(list1 != null && list2 != null)
		{
			if(list2.val < list1.val)
			{
				iter.next = list2;
				iter = iter.next;
				list2 = list2.next;
			}
			else
			{
				iter.next = list1;
				iter = iter.next;
				list1 = list1.next;
			}
		}
		
		while(list1 != null)
		{
			iter.next = list1;
			iter = iter.next;
			list1 = list1.next;
		}

		while(list2 != null)
		{
			iter.next = list2;
			iter = iter.next;
			list2 = list2.next;
		}

		return head;
    }
	
	public static void main(String[] args) throws Exception 
	{
		long t1 = System.currentTimeMillis();
		sample1();
		sample2();
		sample3();
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
	 
	 public static void sample1() //[1,1,2,3,4,4]
	 {
		ListNode ll = createLL(new int[] {1,2,4});
		ListNode ll2 = createLL(new int[] {1,3,4});
		ListNode ans = new MergeLinkedList().mergeTwoLists(ll, ll2);
		printLL(ans);
	 }

	 public static void sample2() //[]
	 {
		ListNode ll = createLL(new int[] {});
		ListNode ll2 = createLL(new int[] {});
		ListNode ans = new MergeLinkedList().mergeTwoLists(ll, ll2);
		printLL(ans);
	 }

	 public static void sample3() //"23451"
	 {
		ListNode ll = createLL(new int[] {});
		ListNode ll2 = createLL(new int[] {0});
		ListNode ans = new MergeLinkedList().mergeTwoLists(ll, ll2);
		printLL(ans);
	 }
	 

}
