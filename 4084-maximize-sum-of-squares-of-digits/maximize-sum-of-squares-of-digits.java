class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";

        int nines = sum / 9;
        int rest = sum % 9;

        StringBuilder sb = new StringBuilder();

        return sb.repeat("9",nines).append(rest).repeat("0",num).substring(0,num);
    }
}