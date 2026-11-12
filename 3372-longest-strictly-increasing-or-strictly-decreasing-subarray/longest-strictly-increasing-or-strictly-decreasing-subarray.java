class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int min  = 1;
        int minn = 1;
        int max = 1;
        int maxx = 1;



        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                max++;
                maxx = Math.max(max, maxx);
            }else{
                max = 1;
            }
            if(nums[i] < nums[i - 1]){
                min++;
                minn = Math.max(min, minn);
            }else{
                min = 1;
            }
        }
        
        return Math.max(maxx,minn);
    }
}