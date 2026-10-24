class Solution {
    int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceA = daysCal(arriveAlice);
        int aliceL = daysCal(leaveAlice);

        int bobA = daysCal(arriveBob);
        int bobL = daysCal(leaveBob);

        int start = Math.max(aliceA, bobA);
        int end = Math.min(aliceL, bobL);

        return start <= end ? end - start + 1 : 0;
    }
    public int daysCal(String s){
        int m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int d = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        int res = d;

        for(int i = 0; i < m - 1; i++) res += days[i];

        return res;
    }
}