class Solution {
    private static final int MOD = 1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounter = new int[31];

        for(int num : nums){

            for(int i = 0; i < bitCounter.length; i++){
                if(((num >> i) & 1) == 1) bitCounter[i]++;
            }
        }

        long ans = 0;

        for(int i = 0; i < k; i++){
            long current = 0;

            for(int b = 0; b < bitCounter.length; b++){
                if(bitCounter[b] > i) current |= (1L << b);
            }

            ans = (ans + current * current % MOD) % MOD;
        }
        return (int) ans;
    }
}