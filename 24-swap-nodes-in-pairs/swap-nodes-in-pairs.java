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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            ListNode next = curr.next;
            ListNode nextP = curr.next.next;

            prev.next = next;
            next.next = curr;
            curr.next = nextP;

            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}