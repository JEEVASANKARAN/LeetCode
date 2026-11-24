class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        long maxi = 1_000_000_000_000L;

        for(int i = 0; i < n; i++){
            long prd = 1;
            long currGcd = 0;
            long currLcm = 1;

            for(int j = i; j < n; j++){
                if(prd > maxi / nums[j]) break;

                prd *= nums[j];
                currGcd = gcd(currGcd, nums[j]);
                currLcm = lcm(currLcm, nums[j]);

                if(prd == currLcm * currGcd) maxLen = Math.max(maxLen, j - i + 1);
            } 
        }
        return maxLen;
    }

    public long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }

        return Math.abs(a);
    }

    public long lcm(long a, long b){
        if(a == 0 || b == 0) return 0;

        return Math.abs(a / gcd(a, b) * b);
    }
}