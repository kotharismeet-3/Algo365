vector<vector<bool>>dp(nums.size(), vector<bool>(k+1, false));
        // base case
        for (int row=0;row<nums.size();row++) {
            dp[row][0] = true;
        }
        dp[0][k] = true;
        // recursion to tabulation
        for (int ind=1;ind<nums.size();ind++) {
            for (int target=k; target<=k;target++) {
                bool notTake = dp[ind-1][target];
                bool take = false;
                if(nums[ind] <= target) take = dp[ind-1][target - nums[i]];
                dp[ind][target] = notTake | take;
                
            }
        }
        return dp[n][target];
