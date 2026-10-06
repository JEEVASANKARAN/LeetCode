class Solution {
    public String minRemoveToMakeValid(String s) {
        List contain = new ArrayList();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') dq.push(i);
            else if(c == ')'){
                if(!dq.isEmpty()) dq.pop();
                else contain.add(i);
            }
        }

        while(!dq.isEmpty()) contain.add(dq.pop());

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!contain.contains(i)){
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}