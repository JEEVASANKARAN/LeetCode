class Solution {
    public int minAddToMakeValid(String s) {
        int count  =0;
        Deque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(') dq.push('(');
            else if(c == ')' && !dq.isEmpty()) dq.pop();
            else count++;
        }
        return dq.size() + count;
    }
}