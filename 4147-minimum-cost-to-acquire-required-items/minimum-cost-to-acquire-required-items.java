class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if((long) cost1 + cost2 <= costBoth) return (long) cost1 * need1 + (long) cost2 * need2;
        long minop = Math.min(need1, need2);
        long totalCost = Math.min((long) costBoth, (long) cost1 + cost2) * minop;

        need1 -= minop;
        need2 -= minop;

        if(need1 > 0) totalCost += Math.min( (long) need1 * costBoth, (long) need1 * cost1);
        if(need2 > 0) totalCost += Math.min( (long) need2 * costBoth, (long) need2 * cost2);

        return totalCost;
    }
}