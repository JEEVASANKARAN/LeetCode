class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb=new StringBuilder();
        Deque<String> dq=new ArrayDeque<>();
        String[] s=path.split("/");
        for(String i: s){
            if(i.equals("")||i.equals(".")) continue;
            else if(i.equals("..")) {
                if(!dq.isEmpty())dq.pollLast();
            }else dq.offerLast(i);
        }

        for(String i:dq){
            sb.append("/").append(i);
        }
        return sb.length()==0?"/":sb.toString();
    }
}