1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        ListNode curr=head;
14        int length=0;
15        while(curr!=null){
16            length++;
17            curr=curr.next;
18        }
19
20        if(length==n) return head.next;
21
22        curr=head;
23
24        for(int i=1;i<length-n;i++){
25            curr=curr.next;
26        }
27        curr.next=curr.next.next;
28        return head;
29    }
30}