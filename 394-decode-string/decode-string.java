class Solution {
    public String decodeString(String s) {
        Deque<Integer> rep = new ArrayDeque<>();
        Deque<StringBuilder> str = new ArrayDeque<>();
        StringBuilder currS = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k=k*10+(c-'0');
            }
            else if(c=='['){
                rep.push(k);
                str.push(currS);
                k=0;
                currS = new StringBuilder();
            }
            else if(c==']'){
                StringBuilder decoded = str.pop();
                int count = rep.pop();
                for(int i = 0; i < count; i++){
                    decoded.append(currS);
                }
                currS=decoded;
            }
            else{
                currS.append(c);
            }
        }
        return currS.toString();
    }
}