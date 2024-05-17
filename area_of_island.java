class Solution {

    private int dfs(int x, int y, int rows, int cols, boolean[][] vis, int[][] grid) {
        vis[x][y] = true;
        int area = 0;
        // RLUD
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i=0;i < 4; i++) {
            if(isValid(x+dx[i], y+dy[i], rows, cols) && 
                grid[x+dx[i]][y+dy[i]] == 1 &&
                !vis[x+dx[i]][y+dy[i]]) {
                    area += dfs(x+dx[i], y+dy[i], rows, cols, vis, grid);
            }
        }
        return area + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = 0, area = 0;
        if(rows > 0) cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    area = Math.max(area, dfs(i, j, rows, cols, vis, grid));
                }
            }
        }
        return area;
    }

    private boolean isValid(int x, int y, int m, int n) {
        if((x >=0 && x < m) && (y >= 0 && y < n)) return true;
        return false;
    }
}