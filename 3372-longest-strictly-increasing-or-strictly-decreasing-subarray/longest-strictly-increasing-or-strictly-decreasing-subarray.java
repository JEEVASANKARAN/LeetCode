class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int min  = 1;
        int max = 1;

        int[] arr1 = new int[n];
        Arrays.fill(arr1,1);
        int[] arr2 = new int[n];
        Arrays.fill(arr2,1);

        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                arr1[i] += arr1[i - 1];
                max = Math.max(max, arr1[i]);
            }
            else if(nums[i] < nums[i - 1]){
                arr2[i] += arr2[i - 1];
                min = Math.max(min, arr2[i]);
            }
        }
        return Math.max(max,min);
    }
}