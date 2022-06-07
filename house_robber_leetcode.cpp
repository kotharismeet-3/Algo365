int rob(vector<int>& nums) {
        if(!nums.size()) return 0;
        else if(nums.size() == 1) return nums[0];
        // else if(nums.size() == 2) return max(nums[0],nums[1]);
        int curr=0,prev,prev2;
        prev2=nums[0];
        prev=max(nums[0],nums[1]);
        for (int i=2;i<nums.size();i++) {
            curr = max(prev2+nums[i],prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
}
