class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3]; // buy will be 0 and 1 and cap will be 0, 1, 2
        for(int ind = n - 1 ; ind >= 0; ind--) {
            for(int buy = 0; buy < 2; buy++) {
                for(int cap = 1; cap < 3; cap++) {
                    // buy index is bit tricky
                    if(buy == 1) {
                        dp[ind][buy][cap] = Math.max(
                            -prices[ind] + dp[ind+1][0][cap],
                            0 + dp[ind+1][1][cap]
                        );
                    } else {
                        dp[ind][buy][cap] = Math.max(
                            prices[ind] + dp[ind+1][1][cap - 1],
                            0 + dp[ind+1][0][cap]
                        );
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}