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
    public int[] nodesBetweenCriticalPoints(ListNode root) {
        if(root == null || root.next == null || root.next.next == null) return new int[]{-1,-1};
        int cc=0;
        int first=0;
        int mov=0;
        int count=1;
        int maxLen=Integer.MIN_VALUE;
        int minLen=Integer.MAX_VALUE;
        ListNode temp=root.next;
        ListNode prev=root;

        while(temp.next != null){
            if((prev.val > temp.val && temp.val < temp.next.val) || (prev.val < temp.val && temp.val > temp.next.val)){
                if(cc == 0){
                    first=count;
                    mov=count;
                }
                else if(cc > 0){
                    minLen=Math.min(minLen,count-mov);
                    maxLen=Math.max(maxLen, count-first);
                    mov=count;
                }
                cc++;
            }
            count++;
            prev=temp;
            temp=temp.next;
        }

        return cc<2 ? new int[]{-1,-1} : new int[]{minLen,maxLen};
    }
}