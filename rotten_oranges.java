class Solution {
    class CustomPair {
        int row;
        int col;
        int time;
        CustomPair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = 0, freshOranges = 0, time = 0, count = 0;
        if(rows > 0) cols = grid[0].length;
        int[][] vis = new int[rows][cols];
        Queue<CustomPair> que = new LinkedList<>();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if(grid[i][j] == 2) {
                    que.add(new CustomPair(i, j, 0));
                    vis[i][j] = 2;
                }
                else if(grid[i][j] == 1){ 
                    freshOranges++;
                    vis[i][j] = 0;
                }
            }
        }
        // RLUD
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!que.isEmpty()) {
            int x = que.peek().row;
            int y = que.peek().col;
            int t = que.peek().time;
            que.remove();
            time = Math.max(time, t);
            // System.out.println(x + " " + y + " " + vis[x][y]);
            for(int i=0;i < 4; i++) {
                if(isValid(x+dx[i], y+dy[i], rows, cols) && 
                    grid[x+dx[i]][y+dy[i]] == 1 &&
                    vis[x+dx[i]][y+dy[i]] != 2) {
                        vis[x+dx[i]][y+dy[i]] = 2;
                        que.add(new CustomPair(x+dx[i], y+dy[i], t+1));
                        count++;
                }
            }
        }
        // System.out.println(freshOranges + " " + count);
        if(freshOranges == count) return time;
        return -1;
    }

    private boolean isValid(int x, int y, int m, int n) {
        if((x >=0 && x < m) && (y >= 0 && y < n)) return true;
        return false;
    }
}