package com.fraza.leetcode;

public class ReverseLLNodes
{
	public static class ListNode 
	{
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode reverseKGroup(ListNode head, int k) //12345
	{
		ListNode start = head;
		ListNode newHead = null;
		ListNode prevEnd = null;
		while(start != null)
		{
			int i=1;
			ListNode iter = start;
			while(iter != null && i<k)
			{
				iter = iter.next;
				i++;
			}
			if(null == newHead && i == k) newHead = iter;
			
			if(null != iter) // reverse this section of LL
			{
				ListNode newStart = iter.next;
				reverseLL(start, k);
				if(prevEnd != null)
					prevEnd.next = iter;
				prevEnd = start;
				start = newStart;
			}
			else
			{
				if(prevEnd != null)
					prevEnd.next = start;
				break;
			}
		}

		return newHead;
    }
	
	private ListNode reverseLL(ListNode start, int k)
	{
		int i=0;
		ListNode curr = start;
		ListNode prev = null;
		ListNode next;
		while(i<k)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		return prev;
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
		sample7();
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
	 
	 public static void sample1() //[2,1,4,3,5]
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		int k = 2;//5
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }

	 public static void sample2() //[3,2,1,6,5,4,7]
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5,6,7});
		int k = 3;//5
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }

	 public static void sample3() //
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5,1,2,3,6,5,1,2,3,4,5,1,6,3,4,5,1,2,3,4,5,6,2,3,4,5,1,2,3,6,5,1,2,3,4,6,1,2,3,4,5});
		int k = 4; //45;
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }
	 
	 public static void sample4() //[]
	 {
		ListNode ll = createLL(new int[] {});
		int k = 2;
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }

	 public static void sample5() //[2]
	 {
		ListNode ll = createLL(new int[] {2});
		int k = 1;
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }

	 public static void sample6() //[2143]
	 {
		ListNode ll = createLL(new int[] {1,2,3,4});
		int k = 2;
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }

	 public static void sample7() //[4321]
	 {
		ListNode ll = createLL(new int[] {1,2,3,4});
		int k = 4;
		ListNode ans = new ReverseLLNodes().reverseKGroup(ll, k);
		printLL(ans);
	 }
}
