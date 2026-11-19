class Solution {
    public int minimizeSum(int[] nums) {
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE, min3 = Long.MAX_VALUE;
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;

        for(int i : nums){
            if(i < min1){
                min3 = min2;
                min2 = min1;
                min1 = i;
            }
            else if(i < min2){
                min3 = min2;
                min2 = i;
            }
            else if(i < min3){
                min3 = i;
            }
            if(i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }
            else if(i > max2){
                max3 = max2;
                max2 = i;
            }
            else if(i > max3){
                max3 = i;
            }
        }

        return (int) Math.min(max1 - min3,Math.min(max3 - min1, max2 - min2));
    }
}