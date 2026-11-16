class Solution {
    public String digitSum(String s, int k) {
        if(s.length() <= k) return s;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i += k){
            int end = Math.min(s.length(), i + k);
            int sum = stringSum(s.substring(i, end));
            sb.append(sum);
        }
        return digitSum(sb.toString(), k);
    }
    public int stringSum(String s){
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += (c - '0');
        }
        return sum;
    }
}