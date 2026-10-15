class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;
        for(int i = 0 ; i < nums.size(); i++){
            Set<Integer> seen = new HashSet<>();

            for(int j = i; j < nums.size(); j++){
                seen.add(nums.get(j));

                int val = seen.size();

                res += Math.pow(val,2);
            }
        }
        return res;
    }
}