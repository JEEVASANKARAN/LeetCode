class Solution {
    public String reverseParentheses(String s) {
        StringBuilder current = new StringBuilder();
        Deque<StringBuilder> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                dq.push(current);
                current = new StringBuilder();
            }
            else if(c == ')'){
                StringBuilder old = dq.pop();
                current = old.append(current.reverse());
            }
            else{
                current.append(c);
            }
        }
        return current.toString();
    }
}