package v5solution.chapter2;

import cc150.common.ListNode;


/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 */
public class Question1 {

  public void removeDuplicateWithoutBuffer(ListNode head) {
    // write implementation here
    if (head == null) {
      return;
    }
    ListNode cur = head;
    while (cur != null) {
      ListNode runner = cur;
      
      while (runner.next != null) {
        if (runner.next.val == cur.val) {
          runner.next = runner.next.next;
        }
        else {
          runner = runner.next;
        }
      }
      
      cur = cur.next;
    }
  }

}