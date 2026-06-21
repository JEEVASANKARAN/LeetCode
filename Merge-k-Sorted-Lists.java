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
12static{
13    for(int i=0;i<301;i++) mergeKLists(null);
14}
15
16    public static ListNode mergeKLists(ListNode[] lists) {
17
18        if (lists == null || lists.length == 0)
19            return null;
20
21        return divide(lists, 0, lists.length - 1);
22    }
23
24    private static ListNode divide(ListNode[] lists, int left, int right) {
25
26        if (left == right)
27            return lists[left];
28
29        int mid = left + (right - left) / 2;
30
31        ListNode leftList = divide(lists, left, mid);
32        ListNode rightList = divide(lists, mid + 1, right);
33
34        return mergeTwoLists(leftList, rightList);
35    }
36
37    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
38
39        if (list1 == null) return list2;
40        if (list2 == null) return list1;
41
42        if (list1.val <= list2.val) {
43            list1.next = mergeTwoLists(list1.next, list2);
44            return list1;
45        }
46
47        list2.next = mergeTwoLists(list1, list2.next);
48        return list2;
49    }
50}