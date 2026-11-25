class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        
        int count = 0;

        if(nums[0] >= nums[1]) count++;
        if(nums[n - 1] >= nums[n - 2]) count++;

        for(int i = 1; i < nums.length - 1; i++){
            int avg = nums[i - 1] + nums[i + 1];
            if(nums[i] * 2 >= avg) count++;
        }
        return count;
    }
}