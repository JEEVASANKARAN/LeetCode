class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sq[] = Arrays.stream(nums).asLongStream().map(x -> x * x).sorted().toArray();
        long total = Arrays.stream(sq).sum();
        long small = Arrays.stream(sq,0,sq.length / 2).sum();

        return total - 2 * small;
    }
}