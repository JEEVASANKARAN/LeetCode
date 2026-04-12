class Solution {
    public int hammingDistance(int x, int y) {
    int diff=x^y;
    int count=Integer.bitCount(diff);
    return count;
    }
}