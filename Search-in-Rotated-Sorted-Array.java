1class Solution {
2    public int search(int[] nums, int target) {
3        int left=0, right=nums.length-1;
4
5while (left<=right) {
6            int mid =left+(right - left)/2;
7     if (nums[mid]==target) {
8   return mid;
9 }
10 if (nums[left]<=nums[mid]) {
11        if (nums[left]<=target && target<nums[mid]) {
12         right=mid-1;
13                }
14                else {
15         left=mid+1;
16    }
17     } 
18            else {
19                if (nums[mid]<target && target<=nums[right]) {
20                    left=mid+1;
21                } 
22                else {
23                    right=mid-1;
24                }
25            }
26        }
27        return -1;
28
29    }
30}