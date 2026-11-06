class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] query = new int[m][2];
        for(int i = 0; i < m; i++){
            query[i][0] = queries[i];
            query[i][1] = i;
        }
        Arrays.sort(query, (a,b) -> Integer.compare(a[0], b[0]));

        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[m];

        Map<Integer,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int L = logs.length;
        int active = 0;

        for(int[] q : query){
            int time = q[0];
            int idx = q[1];

            while(right < L && logs[right][1] <= time){
                int s = logs[right][0];
                map.put(s, map.getOrDefault(s, 0) + 1);

                if(map.get(s) == 1) active++;
                right++;
            }

            while(left < right && logs[left][1] < time - x){
                int s = logs[left][0];
                map.put(s, map.get(s) - 1);

                if(map.get(s) == 0) active--;
                left++;
            }

            res[idx] = n - active;
        }
        return res;
    }
}