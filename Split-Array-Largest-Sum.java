1class Solution {
2    public int splitArray(int[] nums, int k) {
3        int low=0;
4        int high=0;
5        for(int num:nums){
6            low=Math.max(low,num);
7            high+=num;
8        }
9        while(low<high){
10            int mid=low+(high-low)/2;
11            if(canSplit(nums,k,mid)){
12                high=mid;
13            }else{
14                low=mid+1;
15            }
16        }
17        return low;
18    }
19    public boolean canSplit(int[] arr,int k, int maxSum){
20        int currSum=0;
21        int subArray=1;
22        for(int num:arr){
23            if(currSum+num>maxSum){
24                subArray++;
25                currSum=num;
26                if(subArray>k) return false;
27            }else{
28                currSum+=num;
29            }
30        }
31        return true;
32    }
33}