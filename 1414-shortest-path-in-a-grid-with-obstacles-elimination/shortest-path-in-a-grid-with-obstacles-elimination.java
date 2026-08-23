class Solution {
    public int shortestPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] obstacles = new int[n][m];

        for (int[] row : obstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        obstacles[0][0] = mat[0][0];
        q.offer(new int[] { 0, 0 });

        int steps = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                if (i == n - 1 && j == m - 1) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x < 0 || y < 0 || x >= n || y >= m) {
                        continue;
                    }

                    if (obstacles[i][j] + mat[x][y] > k) {
                        continue;
                    }

                    if (obstacles[x][y] <= obstacles[i][j] + mat[x][y]) {
                        continue;
                    }

                    obstacles[x][y] = obstacles[i][j] + mat[x][y];
                    q.offer(new int[] { x, y });
                }
            }

            steps++;
        }

        return -1;
    }
}