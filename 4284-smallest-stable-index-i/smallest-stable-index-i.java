class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] minN = new int[nums.length];
        int value = Integer.MAX_VALUE;

        for(int i = nums.length-1; i >= 0; i--){
            value = Math.min(value,nums[i]);
            minN[i]=value;
        }

        value=0;
        for(int i = 0; i < nums.length; i++){
            value = Math.max(value,nums[i]);

            if(value - minN[i] <= k) return i;
        }
        return -1;
    }
}