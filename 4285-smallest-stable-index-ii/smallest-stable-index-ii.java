class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] minA = new int[nums.length];
        int val = Integer.MAX_VALUE;

        for(int i = nums.length-1; i>-1; i--){
            val = Math.min(val,nums[i]);
            minA[i] = val;
        }

        val=0;
        for(int i = 0; i < nums.length; i++){
            val=Math.max(val,nums[i]);

            if(val-minA[i] <= k) return i;
        }
        return -1;
    }
}