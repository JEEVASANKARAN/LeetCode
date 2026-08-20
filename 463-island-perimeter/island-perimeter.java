class Solution {
    public int islandPerimeter(int[][] grid) {
        int maxPerimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                maxPerimeter += 4 * grid[row][col];
                if (row > 0) {
                    maxPerimeter -= 2 * grid[row - 1][col] * grid[row][col];
                }
                if (col > 0) {
                    maxPerimeter -= 2 * grid[row][col - 1] * grid[row][col];
                }
            }
        }
        return maxPerimeter;
    }
}