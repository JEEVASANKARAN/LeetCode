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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        if(head==null||head.next==null) return head;
14        ListNode dummy=new ListNode();
15        dummy.next=head;
16        ListNode beforeGroup=dummy;
17        ListNode afterGroup=null;
18        ListNode groupStart=null;
19        ListNode groupEnd=null;
20        while(true){
21            groupEnd=beforeGroup;
22            for(int i=0;i<k;i++) {
23                groupEnd=groupEnd.next;
24                if(groupEnd==null) return dummy.next;
25            }
26            afterGroup=groupEnd.next;
27            groupEnd.next=null;
28            groupStart=beforeGroup.next;
29            ListNode newHead=reverse(groupStart);
30            beforeGroup.next=newHead;
31            //after reversal groupstart will technically become groupEnd;
32            groupStart.next=afterGroup;
33            beforeGroup = groupStart;
34        }
35
36    }
37    public ListNode reverse(ListNode l1){
38        ListNode prev=null;
39        ListNode curr=l1;
40        while(curr!=null){
41            ListNode next=curr.next;
42            curr.next=prev;
43            prev=curr;
44            curr=next;
45        }
46        return prev;
47    }
48}