class Solution {
    class Pair{
        int node;
        long time;

        public Pair(int node, long time){
            this.node = node;
            this.time = time;
        }
    }
    List<List<Pair>> graph = new ArrayList<>();
    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        long[] res = new long[n];
        Arrays.fill(res, - 1L);
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges) graph.get(edge[0]).add(new Pair(edge[1], edge[2]));

        Set<Integer>[] received = new HashSet[n];
        for(int i = 0; i < requiredSignals.length; i++) received[i] = new HashSet<>();
        
        boolean[] activated = new boolean[n];
        PriorityQueue<Long>[] arrivals = new PriorityQueue[n];
        for(int i = 0; i < n; i++) arrivals[i] = new PriorityQueue<>(Collections.reverseOrder());
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.offer(new Pair(0, 0L));

        for(int i = 0; i < n; i++){
           if(requiredSignals[i] == 0)
              pq.offer(new Pair(i, 0L));
        }

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            long time = curr.time;

            if(activated[u]) continue;

            activated[u] = true;
            res[u] = time;

            for(Pair neigh : graph.get(u)){
                int v = neigh.node;
                if(activated[v] || v == 0) continue;

                if(received[v].add(u)){
                    arrivals[v].offer(time + neigh.time);

                    if(arrivals[v].size() > requiredSignals[v]) arrivals[v].poll();
                    if(arrivals[v].size() == requiredSignals[v]){
                        pq.offer(new Pair(v, arrivals[v].peek()));
                    }
                }
            }
        }
        return res;
    }
}