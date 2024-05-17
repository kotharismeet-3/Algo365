class Solution {
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = 0, islands = 0;
        if(rows > 0) cols = grid[0].length;
        vis = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    islands++;
                    dfs(i, j, rows, cols, grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int x, int y, int rows, int cols, char[][] grid) {
        vis[x][y] = true;
        // RLUD
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i=0;i<4;i++) {
            if(isValid(x+dx[i], y+dy[i], rows, cols) && !vis[x+dx[i]][y+dy[i]] && 
            grid[x+dx[i]][y+dy[i]] == '1') dfs(x+dx[i], y+dy[i], rows, cols, grid);
        }
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        if((x >= 0 && x < rows) && (y >=0 && y < cols)) return true;
        return false;
    }
}