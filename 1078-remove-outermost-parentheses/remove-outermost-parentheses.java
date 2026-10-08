class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for(char c : s.toCharArray()){
            if(c == '(') depth++;
            if(depth > 1) sb.append(c);
            if(c == ')') depth--;
        }
        return sb.toString();
    }
}