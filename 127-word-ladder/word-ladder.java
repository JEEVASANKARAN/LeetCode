class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
       if(!words.contains(endWord) ) return 0;

        Queue<String> q = new LinkedList<>();
        int steps = 1;
        q.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(endWord)) return steps;

                char[] arr = curr.toCharArray();

                for(int i = 0; i < arr.length; i++){
                    char og = arr[i];
                    for(char j = 'a'; j <= 'z'; j++){
                        if(j == og) continue;
                        arr[i] = j;

                        String next = new String(arr);
                        if(words.contains(next)){
                             q.add(next);
                             words.remove(next);
                        }
                    }
                    arr[i] = og;
                }
            }
            steps++;
        }
        return 0;
    }
}