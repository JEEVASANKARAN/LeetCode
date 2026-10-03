class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(-1);

        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '(') dq.push(i);
            else{
                dq.pop();

                if(dq.isEmpty()) dq.push(i);
                else max = Math.max(max, i - dq.peek());
            }
        }
        return max;
    }
}