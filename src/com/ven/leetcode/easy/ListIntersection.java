package com.ven.leetcode.easy;

public class ListIntersection {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = 0;
		int lengthB = 0;
		ListNode node = headA;
		while (node != null) {
			lengthA++;
			node = node.next;
		}
		node = headB;
		while (node != null) {
			lengthB++;
			node = node.next;
		}

		if (lengthA > lengthB) {
			int moves = lengthA - lengthB;
			while (moves != 0) {
				headA = headA.next;
				moves--;
			}
		} else if (lengthB > lengthA) {
			{
				int moves = lengthB - lengthA;
				while (moves != 0) {
					headB = headB.next;
					moves--;
				}
			}
		}

		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

}
