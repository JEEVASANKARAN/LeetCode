class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start="0000";
        if(dead.contains(start)) return -1;
        q.add(start);
        visited.add(start);
        int turns=0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(target)) return turns;

                for(int i = 0; i<4 ; i++){
                    int digit = curr.charAt(i)-'0';
                    int nextDigit=(digit+1)%10;
                    int prevDigit=(digit+9)%10;

                    String next = curr.substring(0,i)+nextDigit+curr.substring(i+1);
                    String prev = curr.substring(0,i)+prevDigit+curr.substring(i+1);

                    if(!dead.contains(next) && !visited.contains(next)){
                        visited.add(next);
                        q.add(next);
                    }

                    if(!dead.contains(prev) && !visited.contains(prev)){
                        visited.add(prev);
                        q.add(prev);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}