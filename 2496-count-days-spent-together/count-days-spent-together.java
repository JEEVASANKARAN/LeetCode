class Solution {
    int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aStart = toDay(arriveAlice);
        int aEnd = toDay(leaveAlice);
        int bStart = toDay(arriveBob);
        int bEnd = toDay(leaveBob);
        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);
        return start <= end ? end - start + 1 : 0;
    }
    private int toDay(String s) {
        int m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int d = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        int res = d;
        for (int i = 0; i < m - 1; i++) res += days[i];
        return res;
    }
}