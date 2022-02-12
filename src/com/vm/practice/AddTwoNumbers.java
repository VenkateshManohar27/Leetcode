package com.vm.practice;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int l1num = (l1 != null) ? l1.val : 0;
			int l2num = (l2 != null) ? l2.val : 0;
			int sum = l1num + l2num;
			if (carry > 0) {
				sum += carry;
			}
			carry = sum >= 10 ? 1 : 0;
			sum %= 10;
			res.next = new ListNode(sum);
			res = res.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			res.next = new ListNode(carry);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode res = atn.addTwoNumbers(l1, l2);
	 String s = "TEST.290190.20029090902";
	 System.out.println(s.substring(s.lastIndexOf(".")+1));
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
