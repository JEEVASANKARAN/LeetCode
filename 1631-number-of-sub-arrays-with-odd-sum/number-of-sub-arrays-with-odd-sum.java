class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int odd = 0, even = 1;
        int count = 0;
        int MOD = 1_000_000_007;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum % 2 == 0){
                even++;
                count = (count + odd) % MOD;
            }
            else{
                odd++;
                count = (count + even) % MOD;
            }
        }
        return count;
    }
}