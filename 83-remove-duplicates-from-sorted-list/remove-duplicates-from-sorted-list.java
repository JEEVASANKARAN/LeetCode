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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res=new ListNode();
        ListNode lis=res;
        while(head!=null){
            int value=head.val;
            while(head!=null&&head.val==value){
                head=head.next;
            }
            lis.next=new ListNode(value);
            lis=lis.next;
        }
        return res.next;
    }
}