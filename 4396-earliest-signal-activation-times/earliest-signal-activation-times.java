class Solution {
    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build adjacency list
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        long[] ans = new long[n];
        Arrays.fill(ans, -1);

        int[] received = new int[n];

        // Min heap: {arrival time, destination node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Node 0 starts active at time 0
        ans[0] = 0;

        // Send signals from node 0
        for (int[] edge : graph[0]) {
            pq.offer(new long[]{edge[1], edge[0]});
        }

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long time = current[0];
            int node = (int) current[1];

            // Ignore already activated nodes
            if (ans[node] != -1) {
                continue;
            }

            received[node]++;

            // Check activation requirement
            if (received[node] == requiredSignals[node]) {

                ans[node] = time;

                // Send signals to outgoing neighbors
                for (int[] edge : graph[node]) {

                    int next = edge[0];
                    int delay = edge[1];

                    if (ans[next] == -1) {
                        pq.offer(new long[]{
                            time + delay, next
                        });
                    }
                }
            }
        }

        return ans;
    }
}