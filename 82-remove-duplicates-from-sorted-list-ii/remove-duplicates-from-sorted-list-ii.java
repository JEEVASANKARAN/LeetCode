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
            int count=0;
            while(head!=null&&head.val==value){
                head=head.next;
                count++;
            }
            if(count==1){
                lis.next=new ListNode(value);
                lis=lis.next;
            }
        }
        return res.next;
    }
}