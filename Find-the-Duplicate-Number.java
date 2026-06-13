1class Solution {
2    public int findDuplicate(int[] nums) {
3        int fast=nums[0];
4        int slow=nums[0];
5
6        do{
7            fast=nums[nums[fast]];
8            slow=nums[slow];
9        }while(fast!=slow);
10
11        int ptr1=nums[0];
12        int ptr2=slow;
13
14        while(ptr1!=ptr2){
15            ptr1=nums[ptr1];
16            ptr2=nums[ptr2];
17        }
18        return ptr1;
19    }
20}