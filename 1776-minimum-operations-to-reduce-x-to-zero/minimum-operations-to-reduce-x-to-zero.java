class Solution {
    public int minOperations(int[] nums, int x) {
        int k = -x;
        int n = nums.length;

        for(int num : nums) k += num;
        if(k < 0) return -1;
        if(k == 0) return n;

        int i =0;
        int sum =0;
        int best = -1;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];

            while(sum > k){
                sum -= nums[i++];
            }
            if(sum == k) best = Math.max(best,j-i+1);
        }
        return best < 0 ? -1 : n - best;
    }
}