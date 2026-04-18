class Solution {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums == null) return new int[]{};
        int[] result = new int[nums.length];
        int[] frequency = new int[101];

        //Finding frequency
        for(int num:nums) frequency[num]++;
        
        // building sum of elements less that the current
        for(int i=1;i<100;i++) frequency[i]+=frequency[i-1];

        // Giving the 
        for(int i=0;i<nums.length;i++) result[i] = nums[i] == 0 ? 0 : frequency[nums[i] - 1];
        return result;
    }
}