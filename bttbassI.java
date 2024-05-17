class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int size = prices.length, ans = 0;
        // prefix will be prev lowest
        int[] prefix = new int[size];
        prefix[0] = prices[0];
        for(int i=1; i < size; i++) {
            prefix[i] = Math.min(prefix[i-1], prices[i]);
            ans = Math.max(ans, prices[i] - prefix[i]);
        }
        return ans;
    }
}