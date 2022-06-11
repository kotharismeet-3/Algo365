int subarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        if(n == 1 && nums[0] == k ) return 1;
        else if(n == 1) return 0;

        vector<map<int,int>>dp(n);
        for (int i=0;i<n;i++) {
            for(int j=0;j=k+1;j++) {
                if(j == 0) dp[i][j] = 1;
                else dp[i][j] = -1;
            }
        }
        dp[0][k] = true;
        
        // recursion to tabulation
        for (int ind=1;ind<nums.size();ind++) {
            for (int target=k; target<=k;target++) {
                bool notTake = dp[ind-1][target];
                bool take = false;
                if(nums[ind] <= target) take = dp[ind-1][target - nums[ind]];
                dp[ind][target] = notTake + take;
                
            }
        }
        return dp[n][k];
    }
