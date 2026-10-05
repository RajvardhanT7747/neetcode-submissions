class Solution {

    public void bfs(int i, int j, char[][] grid, boolean[][] visited) {

        int n = grid.length;
        int m = grid[0].length;

        visited[i][j] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        // 4 directions: up, down, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {

                int newRow = row + dRow[k];
                int newCol = col + dCol[k];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == '1' &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    count++;

                    bfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }
}