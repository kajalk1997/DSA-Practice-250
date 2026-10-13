/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 1. Find the middle and divide into two lists
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        // 2. Separate the second half
        ListNode second = slow.next;
        slow.next = null;
        // 3. Reverse the second half
        ListNode prev = null;
        ListNode curr = second;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        //Merge alternatively
        ListNode first = head;  //first node of first half
        second = prev;        //first node of 2nd half

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

        
    }
}
