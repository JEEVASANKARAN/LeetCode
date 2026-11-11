class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minop = Math.min(need1, need2);;
        long totalCost = Math.min((long) costBoth, (long) cost1 + cost2) * minop;

        need1 -= minop;
        need2 -= minop;

        totalCost += Math.min( (long) need1 * costBoth, (long) need1 * cost1);
        totalCost += Math.min( (long) need2 * costBoth, (long) need2 * cost2);

        return totalCost;
    }
}