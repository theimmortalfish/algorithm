package common;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		this.val = arr[0];
		ListNode pre = this;
		for (int i = 1; i < arr.length; i++) {
			ListNode cur = new ListNode(arr[i]);
			pre.next = cur;
			pre = cur;
		}
	}

	public static boolean listEqual(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null) {
			return true;
		} else if (head1 != null && head2 != null) {
			return (head1.val == head2.val)
					&& listEqual(head1.next, head2.next);
		} else {
			return false;
		}
	}

	public static ListNode arrayToList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode cur = head;
		for (int i = 1; i < arr.length; ++i) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return head;
	}

	public static void printList(ListNode node) {
		System.out.print("Printing node " + node + ": ");
		if (node == null) {
			System.out.print("empty list");
		} else {
			while (node != null) {
				System.out.print(node.val + " ");
				node = node.next;
			}
		}
		System.out.println();
	}
}