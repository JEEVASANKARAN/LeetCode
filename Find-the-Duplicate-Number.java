1class Solution {
2    public int findDuplicate(int[] nums) {
3        int[] freq=new int[nums.length];
4        for(int x: nums) freq[x]++;
5        int res=0;
6        for(int i=1;i<freq.length;i++) if(freq[i]>1) res=i;
7        return res;
8    }
9}