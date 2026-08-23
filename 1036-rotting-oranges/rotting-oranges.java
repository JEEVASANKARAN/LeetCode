class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        int[][] directions = {
                { -1, 0 }, { 1, 0 },
                { 0, -1 }, { 0, 1 }
        };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] direction : directions) {
                    int nr = direction[0] + r;
                    int nc = direction[1] + c;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            fresh--;
                            q.add(new int[] { nr, nc });
                        }
                    }
                }
            }
            count++;
        }
        return fresh == 0 ? count : -1;
    }
}