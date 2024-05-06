class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // in DP with strings, intialize first row and col as 0 becuase empty strings are also subsequence with lenght 0
        int rows = text1.length() + 1, cols = text2.length() + 1;
        int[][] dp = new int[rows][cols];
        // 0 | a | b | c | d | e
        // --|---|---|---|---|--
        // 0 | 0 | 0 | 0 | 0 | 0
        //a0 | 1 | 1 | 1 | 1 | 1
        //c0 | 1 | 1 | 2 | 2 | 2
        //e0 | 1 | 1 | 2 | 2 | 3

        for(int i = 1; i < rows ; i++) {
            for (int j = 1; j < cols; j++) {                
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(
                    dp[i-1][j],
                    dp[i][j-1]
                );
            }
        }
        // debugStringDp(dp);
        return dp[rows - 1][cols - 1];
    }

    private void debugStringDp(int[][] dp) {
        for(int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}