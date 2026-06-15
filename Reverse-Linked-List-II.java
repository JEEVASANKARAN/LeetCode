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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if(left==right||head==null) return head;
14        ListNode dummy=new ListNode(0);
15        dummy.next=head;
16        ListNode beforeLeft=dummy;
17
18        for(int i=1;i<left;i++){
19            beforeLeft=beforeLeft.next;
20        }
21
22        ListNode atLeft=beforeLeft.next;
23        ListNode atRight=atLeft;
24
25        for(int i=left;i<right;i++){
26            atRight=atRight.next;
27        }
28
29        ListNode afterRight=atRight.next;
30        beforeLeft.next=null;
31        atRight.next=null;
32
33        ListNode midPart=reverse(atLeft);
34        beforeLeft.next=midPart;
35        atLeft.next=afterRight;
36
37        return dummy.next;
38
39    }
40    public ListNode reverse(ListNode head){
41        ListNode prev=null;
42        ListNode curr=head;
43        while(curr!=null){
44            ListNode next=curr.next;
45            curr.next=prev;
46            prev=curr;
47            curr=next;
48        }
49        return prev;
50    }
51}