package com.fraza.leetcode;

public class RotateLinkedList
{
	 public static class ListNode 
	 {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode rotateRight(ListNode head, int k) 
	{
		ListNode toRotate = head;
		ListNode iter = head;
		int j=0;
		while( iter.next != null)
		{
			iter = iter.next;
			j++;

			if(j > k)
			{
				toRotate = toRotate.next;
			}
		}
		
		if(k > j+1)
		{
			k = k%(j+1);
			j = 0;
			
			toRotate = head;
			iter = head;
			while( iter.next != null)
			{
				iter = iter.next;
				j++;

				if(j > k)
				{
					toRotate = toRotate.next;
				}
			}
		}
		
		if(k == 0 || k%(j+1) == 0) return head;
		ListNode newHead = toRotate.next;
		toRotate.next = null;
		iter.next = head;
		
		return newHead;
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
		sample8();
		System.out.println("Time = "+ (System.currentTimeMillis() - t1));
	}
	 
	 public static ListNode createLL(int[] arr)
	 {
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
			while(ll.next != null)
			{
				System.out.print(ll.val + " -> ");
				ll = ll.next;
			}
			System.out.println(ll.val);
	 }
	 
	 public static void sample1() //"4,5,1,2,3"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 2);
		printLL(ans);
	 }

	 public static void sample2() //"2,0,1"
	 {
		ListNode ll = createLL(new int[] {0,1,2});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 4);
		printLL(ans);
	 }

	 public static void sample3() //"23451"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 4);
		printLL(ans);
	 }
	 
	 public static void sample4() //"12345"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 5);
		printLL(ans);
	 }

	 public static void sample5() //"51234"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 6);
		printLL(ans);
	 }
	 
	 public static void sample6() //"4,5,1,2,3"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 42);
		printLL(ans);
	 }

	 public static void sample7() //"4,5,1,2,3"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 0);
		printLL(ans);
	 }

	 public static void sample8() //"4,5,1,2,3"
	 {
		ListNode ll = createLL(new int[] {1,2,3,4,5});
		ListNode ans = new RotateLinkedList().rotateRight(ll, 40);
		printLL(ans);
	 }
}
