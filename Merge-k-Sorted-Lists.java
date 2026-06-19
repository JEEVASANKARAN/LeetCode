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
12
13    public ListNode mergeKLists(ListNode[] lists) {
14
15        if (lists == null || lists.length == 0)
16            return null;
17
18        return divide(lists, 0, lists.length - 1);
19    }
20
21    private ListNode divide(ListNode[] lists, int left, int right) {
22
23        if (left == right)
24            return lists[left];
25
26        int mid = left + (right - left) / 2;
27
28        ListNode leftList = divide(lists, left, mid);
29        ListNode rightList = divide(lists, mid + 1, right);
30
31        return mergeTwoLists(leftList, rightList);
32    }
33
34    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
35
36        if (list1 == null) return list2;
37        if (list2 == null) return list1;
38
39        if (list1.val <= list2.val) {
40            list1.next = mergeTwoLists(list1.next, list2);
41            return list1;
42        }
43
44        list2.next = mergeTwoLists(list1, list2.next);
45        return list2;
46    }
47}