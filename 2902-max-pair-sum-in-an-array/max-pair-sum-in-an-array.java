class Solution {
    public int maxSum(int[] nums) {

        int[] best = new int[10];
        Arrays.fill(best, -1);

        int ans = -1;

        for(int num : nums){

            int d = maxDigit(num);

            if(best[d] != -1){
                ans = Math.max(ans, best[d] + num);
            }

            best[d] = Math.max(best[d], num);
        }

        return ans;
    }

    public int maxDigit(int num){
        int max = 0;

        while(num > 0){
            max = Math.max(max, num % 10);
            num /= 10;
        }

        return max;
    }
}