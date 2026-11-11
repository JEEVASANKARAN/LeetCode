class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minop = Math.min(need1, need2);;
        long minCost = Math.min(costBoth, cost1 + cost2) * minop;

        long rem1 = Math.min((need1 - minop) * costBoth, (need1 - minop) * cost1);
        long rem2 = Math.min((need2 - minop) * costBoth, (need2 - minop) * cost2);

        return minCost + rem1 + rem2;
    }
}